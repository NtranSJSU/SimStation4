// PlagueSimulation.java

package plague;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PlagueSimulation extends Simulation {

    public static final int VIRULENCE = 20; // % chance of infection
    public static final int RESISTANCE = 50; // % chance of resisting infection

    @Override
    public void populate() {
        for (int i = 0; i < 50; i++)
            addAgent(new PlagueAgent(VIRULENCE, RESISTANCE));

        PlagueAgent infected = (PlagueAgent)agents.getFirst();
        infected.setInfected(true);
    }


    public void getStats() {
        // Calculate statistics
        int infectedCount = 0;
        for (Agent agent : getAgents()) {
            PlagueAgent plagueAgent = (PlagueAgent) agent;
            if (plagueAgent.isInfected()) {
                infectedCount++;
            }
        }
        double percentInfected = ((double)Math.round(1000*((double)infectedCount) / getAgents().size())) / 10;

        // Display statistics
        String[] stats = {
                "#agents = " + getAgents().size(),
                "clock = " + time,
                "% infected = " + percentInfected};
        Utilities.inform(stats);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
