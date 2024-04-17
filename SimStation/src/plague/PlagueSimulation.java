// PlagueSimulation.java

package plague;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    @Override
    public void populate() {
        for (int i = 0; i < 50; i++)
            addAgent(new PlagueAgent());
    }


    public void statistic() {
        // Calculate statistics
        int infectedCount = 0;
        for (Agent agent : getAgents()) {
            PlagueAgent plagueAgent = (PlagueAgent) agent;
            if (plagueAgent.isInfected()) {
                infectedCount++;
            }
        }
        double percentInfected = ((double) infectedCount / getAgents().size()) * 100;

        // Display statistics
        String[] stats = {"#agents = " + getAgents().size(), "clock = " + time, "% infected = " + percentInfected};
        Utilities.inform(stats);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
