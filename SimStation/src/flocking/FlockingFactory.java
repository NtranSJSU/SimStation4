package SimStation.flocking;

import SimStation.SimulationFactory;
import mvc.Model;

public class FlockingFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        return new FlockingSimulation();
        //returns new flocking model (like society)
    }

    @Override
    public String getTitle() { //go to line 50
        return "Flocking Simulator";
    }
}
