package SimStation;

import java.util.ArrayList;
import java.util.List;
import mvc.Model;

public class SimStationModel extends Model {
    private List<Agent> agents;
    private boolean simulationRunning;

    public SimStationModel() {
        agents = new ArrayList<>();
        simulationRunning = false;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
        changed();
    }

    public void removeAgent(Agent agent) {
        agents.remove(agent);
        changed();
    }

    public boolean isSimulationRunning() {
        return simulationRunning;
    }

    public void setSimulationRunning(boolean simulationRunning) {
        this.simulationRunning = simulationRunning;
        changed();
    }

    public void startSimulation() {
        // start the simulation
        setSimulationRunning(true);
    }

    public void stopSimulation() {
        // stop the simulation
        setSimulationRunning(false);
    }

    public void suspendSimulation() {
        // suspend the simulation
        setSimulationRunning(false);
    }

    public void resumeSimulation() {
        // resume the simulation
        setSimulationRunning(true);
    }
}
