package SimStation.flocking;

import SimStation.Agent;
import SimStation.Simulation;
import SimStation.SimulationPanel;
import mvc.AppPanel;
import mvc.Utilities;

public class FlockingSimulation extends Simulation {

    public void populate() {
        for (int i = 0; i < 15; i++) {
            addAgent(new Bird());
        }
    }

    @Override
    public void statistic() {
        String[] birds = new String[agents.size()];
        for (int i = 0; i < agents.size(); i++) {
            Agent agent = agents.get(i);
            Bird bird = (Bird) agent;
            birds[i] = "#birds @ speed " + (i + 1) + " = " + bird.speed;
        }
        Utilities.inform(birds);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
