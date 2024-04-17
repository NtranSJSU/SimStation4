package plague;

import simstation.Agent;
import simstation.Heading;
import java.awt.Color;
import java.awt.Graphics;
import mvc.Utilities;

public class PlagueAgent extends Agent {
    private boolean infected;
    private Color color;  // Define the color attribute
    private int speed;

    public PlagueAgent() {
        super();
        infected = false;
        heading = Heading.random(); // Set a random heading
        speed = Utilities.rng.nextInt(5) + 1; // Set a random speed between 1 and 5
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
        move(speed);

        if (!infected) {
            // If the agent is not infected, check for nearby infected agents
            for (Agent neighbor : world.getAgents()) {
                if (neighbor != this && ((PlagueAgent) neighbor).isInfected()) {
                    // Determine if this agent gets infected based on VIRULENCE
                    if (PlagueSimulation.VIRULENCE >= Math.random() * 100) {
                        infected = true;
                        break;
                    }
                }
            }
        }

        // Set color based on infection status
        if (infected) {
            // Set the color to red if infected
            color = Color.RED;
        } else {
            // Set the color to green if not infected
            color = Color.GREEN;
        }
    }

    @Override
    public void draw(Graphics g) {
        // Set the color of the agent's shape or representation
        g.setColor(color);
        super.draw(g); // Call the superclass method to draw the agent
    }
}
