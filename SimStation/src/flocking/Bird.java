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
        int s1, s2, s3, s4, s5;
        s1 = s2 = s3 = s4 = s5 = 0;
        for (int i = 0; i < agents.size(); i++) {
            Agent agent = agents.get(i);
            Bird bird = (Bird) agent;
            if (bird.speed == 1) s1++;
            if (bird.speed == 2) s2++;
            if (bird.speed == 3) s3++;
            if (bird.speed == 4) s4++;
            if (bird.speed == 5) s5++;
        }
        String[] birdSpeed = {
                "#birds @ speed 1 = " + s1,
                "#birds @ speed 2 = " + s2,
                "#birds @ speed 3 = " + s3,
                "#birds @ speed 4 = " + s4,
                "#birds @ speed 5 = " + s5
        };
        Utilities.inform(birdSpeed);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
