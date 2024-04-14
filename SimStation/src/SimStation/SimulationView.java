package SimStation;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class SimulationView extends View {
    public SimulationView(Model model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        gc.setColor(Color.WHITE);
        //for loop through the getNeighbors...
            //gc.fillOval(agent.xc, agent.yc, 1, 1)
        update();

    }

    public void update() {
        repaint();
        //don't forget parameters:
            //agent xCoord, agent yCoord, bounded area (i.e. what it should cover)
                //i.e. bounded area = height & width
    }
}
