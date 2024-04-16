package simstation;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import mvc.Model;
import mvc.Utilities;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Implemented Simulation model
 */
public class Simulation extends Model {
    protected List<Agent> agents;
    private boolean simulationRunning;

    transient private Timer clock;

    protected int time;

    public Simulation() {
        super();
        agents = new ArrayList<>();
        simulationRunning = false;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
        agent.setWorld(this);
        changed();
    }

    public void removeAgent(Agent agent) {
        agents.remove(agent);
        changed();
    }

    public void makeThreads() {
        for (Agent a: agents){
            Thread thread = new Thread(a);
            thread.start();
        }
    }
    private class TimerUpdate extends TimerTask {
        public void run() {
            time++;
        }
    }

    private void startClock(){
            clock = new Timer();
            clock.scheduleAtFixedRate(new TimerUpdate(), 1000, 1000);
    }

    private void stopClock() {
        if (clock != null) {
            clock.cancel();
            clock.purge();
        }
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
        for (Agent a: agents) a.stop();
        time = 0;
        agents.clear();
        this.populate();
        startClock();
        makeThreads();
    }

    public void stopSimulation() {
        // stop the simulation
        setSimulationRunning(false);
        stopClock();
        for (Agent a: agents) a.stop();
    }

    public void suspendSimulation() {
        // suspend the simulation
        setSimulationRunning(false);
        stopClock();
        for (Agent a: agents) a.interrupt();
    }

    public void resumeSimulation() {
        // resume the simulation
        setSimulationRunning(true);
        startClock();
        for (Agent a: agents) a.resume();
    }

    public void populate(){

    }

    public Agent getNeighbor(Agent a, double r){
        int rand = Utilities.rng.nextInt(agents.size());
        for (int i = rand + 1; i % agents.size() != rand; i++){
            Agent k = agents.get(i % agents.size());
            if (k.equals(a)) continue;
            int x = a.getX() - k.getX();
            int y = a.getY() - k.getY();
            if (Math.abs(Math.hypot(x,y)) <= r) return k;
        }
        return null;
    }

    public void statistic() {
        Utilities.inform(new String[] {"Number of Agents: " + agents.size(), "Timer: " + time});
    }
}
