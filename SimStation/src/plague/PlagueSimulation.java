// PlagueSimulation.java

package plague;

import mvc.AppPanel;
import plague.PlagueFactory;
import simstation.Agent;
import simstation.Simulation;
import mvc.Utilities;
import simstation.SimulationPanel;

public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    @Override
    public void populate() {
        for (int i = 0; i < 50; i++)
            addAgent(new PlagueAgent());
    }

    public void simulate() {
        while (true) {
            // Update agents
            for (Agent agent : getAgents()) {
                PlagueAgent plagueAgent = (PlagueAgent) agent;
                plagueAgent.update();
            }

            // Calculate and display statistics
            calculateAndDisplayStats();

            // Sleep for a while to slow down the simulation
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void calculateAndDisplayStats() {
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
