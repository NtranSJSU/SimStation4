package flocking;

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
        Bird b = (Bird) world.getNeighbor(this, 20);
        if (b != null) {
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
