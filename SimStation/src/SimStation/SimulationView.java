package SimStation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.util.List;

public class SimulationView extends View {

    private List<Agent> agentList;

    public SimulationView(Model model) {
        super(model);
        //the stuff within the constructor declares the casting and shit
        //this way the other methods (not only paintcomponent) has access to the list of stuff
        //do the same thing as line 14 in gridView
        Simulation sim = (Simulation)model;
        agentList = sim.getAgents();
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        gc.setColor(Color.LIGHT_GRAY);
        for (Agent agent : agentList) {
            gc.fillOval(agent.xcoord, agent.ycoord, 1, 1);
            repaint();
        }
        //for loop through the getNeighbors...?
            //gc.fillOval(agent.xc, agent.yc, 1, 1)
            //just call repaint() method, so that it repaints EVERYTHING just to move a few agents
            //it's not very efficient, but it's whatever i just want it to work

        update();

    }

    public void update() {
        repaint();
    }
}
