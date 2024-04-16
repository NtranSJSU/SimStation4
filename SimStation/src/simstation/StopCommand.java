package simstation;

import mvc.Model;
import mvc.Command;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Implement StopCommand
 */
public class StopCommand extends Command{
    public StopCommand(Model model){
        super(model);
    }

    @Override
    public void execute(){
        ((Simulation)model).stopSimulation();
    }
}
