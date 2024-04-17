package simstation.flocking;

import simstation.SimulationFactory;
import mvc.Model;

public class FlockingFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        return new FlockingSimulation();
    }

    @Override
    public String getTitle() { //go to line 50
        return "Flocking Simulator";
    }
}
