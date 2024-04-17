package simstation.flocking;

import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;
import mvc.Utilities;

public class Bird extends Agent {
    public int speed;

    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    @Override
    public void update() {
        Simulation world = getWorld();
        Agent neighbor = world.getNeighbor(this, 15);
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
