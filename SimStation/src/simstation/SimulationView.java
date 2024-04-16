package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.util.List;
/*
Date: 4/15/2024
Name: Nhat Tran
Update: Fixed paintComponent to correctly draw agents
 */
public class SimulationView extends View {


    public SimulationView(Model model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {
        Simulation sim = (Simulation)model;
        super.paintComponent(gc);
        Color old = gc.getColor();
        for (Agent agent : sim.agents) {
            agent.draw(gc);
        }

        gc.setColor(old);
        update();

    }

    public void update() {
        repaint();
    }
}
