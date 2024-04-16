package simstation;

import mvc.Command;
import mvc.Model;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Implement SuspendCommand
 */
public class SuspendCommand extends Command {
    public SuspendCommand(Model model){
        super(model);
    }

    @Override
    public void execute(){
        ((Simulation)model).suspendSimulation();
    }
}
