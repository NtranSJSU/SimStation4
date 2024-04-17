package flocking;

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

    public String about() { return "Flocking Simulator made by Rayhann Kwon"; }
}
