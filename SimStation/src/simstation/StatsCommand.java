package simstation;

import mvc.Command;
import mvc.Model;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Implement StatsCommand
 */
public class StatsCommand extends Command{
    public StatsCommand(Model model){
        super(model);
    }

    @Override
    public void execute() {
        ((Simulation)model).statistic();
    }
}
