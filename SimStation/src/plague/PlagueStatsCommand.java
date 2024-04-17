package plague;

import mvc.Command;

public class PlagueStatsCommand extends Command {

    public PlagueStatsCommand(PlagueSimulation model) {
        super(model);
    }

    @Override
    public void execute() {
        ((PlagueSimulation) model).calculateAndDisplayStats();
    }
}
