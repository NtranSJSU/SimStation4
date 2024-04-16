package simstation;

import mvc.Command;
import mvc.Model;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Implement StartCommand
 */
public class StartCommand extends Command {
    public StartCommand(Model model){
        super(model);
    }

    @Override
    public void execute(){
        ((Simulation)model).startSimulation();
    }
}
