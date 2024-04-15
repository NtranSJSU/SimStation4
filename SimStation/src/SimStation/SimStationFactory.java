package SimStation;

import mvc.*;

public class SimStationFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new SimStationModel(); // Create a new instance of SimModel
    }

    @Override
    public View makeView(Model model) {
        return new SimulationView(model); // Create a new instance of SimView
    }

    @Override
    public String getTitle() {
        return "SimStation"; // Set the title for the application
    }

    @Override
    public String[] getHelp() {
        // Provide help information for the application
        return new String[]{"SimStation Help Information"};
    }

    @Override
    public String about() {
        // Provide about information for the application
        return "About SimStation";
    }

    @Override
    public String[] getEditCommands() {
        // Provide edit commands for the application
        return new String[]{"Edit Command 1", "Edit Command 2"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        // Create and return subclass of Command
        return new Command(model) {
            private String commandType = type;
            private Object commandSource = source;

            @Override
            public void execute() {
                // Implement the execution logic based on the type and source
                System.out.println("Executing command: " + commandType + " from " + commandSource.toString());
            }
        };
    }
}
