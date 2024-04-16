package simstation;

import mvc.Command;
import mvc.Model;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Implement ResumeCommand
 */
public class ResumeCommand extends Command {
    public ResumeCommand(Model model){
        super(model);
    }

    @Override
    public void execute() {
        ((Simulation)model).resumeSimulation();
    }
}
