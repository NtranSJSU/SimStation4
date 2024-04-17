package pdtournament;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;
/*
Date: 4/16/2024
Name: Nhat Tran
Update: Implementing PrisonerDilemmaSimulation.java
 */
public class PrisonerDilemmaSimulation extends Simulation {
    public void populate(){
        for (int i = 0; i < 5; i++){
            addAgent(new Prisoner(new Cooperate(), StrategyType.coop));
            addAgent(new Prisoner(new Cheat(), StrategyType.cheat));
            addAgent(new Prisoner(new RandomlyCooperate(), StrategyType.randCoop));
            addAgent(new Prisoner(new Tit4Tat(), StrategyType.tit4Tat));
        }
    }

    @Override
    public void getStats(){
        int avgCoop = 0;
        int avgCheat = 0;
        int avgRandCoop = 0;
        int avgTit4Tat = 0;
        for (Agent a: agents){
            Prisoner prisoner = (Prisoner)a;
            if (prisoner.getStrategies() == StrategyType.coop){
                avgCoop += prisoner.getFitness();
            }
            else if (prisoner.getStrategies() == StrategyType.cheat){
                avgCheat += prisoner.getFitness();
            }
            else if (prisoner.getStrategies() == StrategyType.randCoop){
                avgRandCoop += prisoner.getFitness();
            }
            else if (prisoner.getStrategies() == StrategyType.tit4Tat){
                avgTit4Tat += prisoner.getFitness();
            }
        }

        String[] stats = {
                "#agents = " + agents.size(),
                "clock = " + time,
                "Average Cooperage = " + String.format("%.2f", (double)avgCoop/agents.size()/4),
                "Average Cheat = " + String.format("%.2f", (double)avgCheat/agents.size()/4),
                "Average Randomly Cooperate = " + String.format("%.2f", (double)avgRandCoop/agents.size()/4),
                "Average Tit 4 Tat = " + String.format("%.2f", (double)avgTit4Tat/agents.size()/4)
        };
        Utilities.inform(stats);

    }

    public static void main(String[] args){
        AppPanel panel = new SimulationPanel(new PrisonerDilemmaFactory());
        panel.display();
    }
}
