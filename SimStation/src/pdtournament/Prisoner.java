package pdtournament;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

import java.awt.*;
/*
Date: 4/16/2024
Name: Nhat Tran
Update: Implementing Prisoner.java
 */
public class Prisoner extends Agent {

    private int fitness = 0;
    private boolean partnerCheated = false;
    private StrategyType type;
    Strategy strat;

    public Prisoner(Strategy s, StrategyType stratType){
        this.strat = s;
        s.setPrisoner(this);
        this.type = stratType;
    }

    public StrategyType getStrategies(){
        return type;
    }

    public int getFitness(){
        return fitness;
    }

    public void setFitness(int x){
        fitness += x;
    }

    public boolean cooperate(){
        return partnerCheated;
    }

    @Override
    public void update(){
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        Prisoner prisoner = (Prisoner)world.getNeighbor(this, 8);
        if (prisoner != null){

            boolean prisonerOne = this.strat.cooperate();
            boolean prisonerTwo = prisoner.strat.cooperate();

            if(prisonerOne && prisonerTwo){
                this.setFitness(3);
                this.partnerCheated = false;

                prisoner.setFitness(3);
                prisoner.partnerCheated = false;
            }

            else if (prisonerOne){
                this.partnerCheated = false;

                prisoner.setFitness(5);
                prisoner.partnerCheated = true;
            }

            else if (prisonerTwo){
                this.setFitness(5);
                this.partnerCheated = true;

                prisoner.partnerCheated = false;
            }

            else {
                this.setFitness(1);
                this.partnerCheated = true;

                prisoner.setFitness(1);
                prisoner.partnerCheated = true;
            }
        }
    }

    @Override
    public synchronized void draw(Graphics gc){
        switch(type){
            case coop: {
                gc.setColor(Color.YELLOW);
                break;
            }
            case cheat: {
                gc.setColor(Color.BLACK);
                break;
            }
            case randCoop: {
                gc.setColor(Color.BLUE);
                break;
            }
            case tit4Tat: {
                gc.setColor(Color.RED);
                break;
            }
        }
        gc.drawRect(xcoord, ycoord, 2, 2);
    }
}
