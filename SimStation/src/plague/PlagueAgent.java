package plague;

import simstation.Agent;
import simstation.Heading;
import java.awt.Color;
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
            color = Color.RED;
        } else {
            color = Color.GREEN;
        }
    }

    // Add a method to get the color
    public Color getColor() {
        return color;
    }
}
