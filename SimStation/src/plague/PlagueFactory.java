package plague;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import simstation.StatsCommand;
import plague.PlagueStatsCommand;

public class PlagueFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public mvc.View makeView(Model model) {
        return new simstation.SimulationView(model);
    }

    @Override
    public String getTitle() {
        return "Plague Simulation";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"Plague Simulation Help Information"};
    }

    @Override
    public String about() {
        return "About Plague Simulation";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Stats")) return new PlagueStatsCommand((PlagueSimulation) model);
        return null;
    }
}
