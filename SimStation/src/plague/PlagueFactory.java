package plague;

import simstation.SimulationFactory;
import mvc.Model;

public class PlagueFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public String getTitle() { //go to line 50
        return "Plague Simulator";
    }

    public String about() { return "Plague Simulator "; }
}
