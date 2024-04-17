package plague;

import simstation.Agent;
import simstation.Heading;
import java.awt.Color;
import java.awt.Graphics;
import mvc.Utilities;

public class PlagueAgent extends Agent {
    private boolean infected;
    private final int VIRULENCE;
    private final int RESISTANCE;

    public PlagueAgent(int virulence, int resistance) {
        super();
        VIRULENCE = virulence;
        RESISTANCE = resistance;
        infected = (Utilities.rng.nextInt(100) < virulence && Utilities.rng.nextInt(100) > resistance);
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    @Override
    public void update() {

        // Move the agent according to its speed and heading
        heading = Heading.random();
        int step = Utilities.rng.nextInt(5) + 1;
        move(step);

        if (!infected) {
            return;
        }

        PlagueAgent neighbor = (PlagueAgent) world.getNeighbor(this, 8);
        if (neighbor != null && !neighbor.isInfected()){
            neighbor.infect(VIRULENCE);
        }
    }

    private void infect(int virulence){
        infected = (Utilities.rng.nextInt(100) < virulence && Utilities.rng.nextInt(100) > RESISTANCE);
    }

    @Override
    public void draw(Graphics g) {
        // Set the color of the agent's shape or representation
        g.setColor((infected) ? Color.RED : Color.GREEN);
        g.drawRect(xcoord, ycoord, 2, 2); // Call the superclass method to draw the agent
    }
}
