package simstation;

import mvc.*;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Fixed Factory to respond to each buttons with their separate command class
 */
public class SimulationFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Simulation(); // Create a new instance of SimModel
    }

    @Override
    public View makeView(Model model) {
        return new SimulationView(model); // Create a new instance of SimView
    }

    @Override
    public String getTitle() {
        return "SimStation Simulation"; // Set the title for the application
    }

    @Override
    public String[] getHelp() {
        // Provide help information for the application
        return new String[]{
                "SimStation Help Information",
                "Start: initialize the selected simulation",
                "Suspend: Pause the current simulation",
                "Resume: continue/Unpause the current simulation",
                "Stop: terminate the currently running simulation",
                "Stats: Show statistics related to the simulation"};
    }

    @Override
    public String about() {
        // Provide about information for the application
        return "SimStation Model by :Nhat Tran, Max Zlochevsky, Rayhann Kwon";
    }

    @Override
    public String[] getEditCommands() {
        // Provide edit commands for the application
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        // Create and return subclass of Command
        if (type.equals("Start")) return new StartCommand(model);
        if (type.equals("Suspend")) return new SuspendCommand(model);
        if (type.equals("Resume")) return new ResumeCommand(model);
        if (type.equals("Stop")) return new StopCommand(model);
        if (type.equals("Stats")) return new StatsCommand(model);
        return null;
    }
}
