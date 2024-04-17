package pdtournament;

import mvc.Model;
import simstation.SimulationFactory;
/*
Date: 4/16/2024
Name: Nhat Tran
Update: Implementing PrisonerDilemmaFactory.java
 */
public class PrisonerDilemmaFactory extends SimulationFactory {
    public Model makeModel() {
        return new PrisonerDilemmaSimulation();
    }

    public String getTitle(){
        return "Prisoner's Dilemma Tournament Simulation";
    }

    public String about(){
        return "Prisoner's Dilemma Tournament Simulation";
    }
}
