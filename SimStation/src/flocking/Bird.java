package SimStation.flocking;

import SimStation.Agent;
import SimStation.Heading;
import SimStation.Simulation;
import mvc.Utilities;

public class Bird extends Agent {
    public int speed;

    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(10);
    }

    @Override
    public void update() {
        Simulation world = getWorld();
        Agent neighbor = world.getNeighbor(this, 10);
        if (neighbor != null) {
            Bird b = (Bird) neighbor;
            int steps = b.speed;
            heading = b.heading;
            speed = b.speed;
            move(steps);
        }
        else {
            move(speed);
        }
    }
}
