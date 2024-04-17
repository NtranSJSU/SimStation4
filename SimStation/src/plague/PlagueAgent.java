package plague;

import simstation.Agent;
import java.awt.Color;

public class PlagueAgent extends Agent {
    private boolean infected;
    private Color color;  // Define the color attribute

    public PlagueAgent() {
        super();
        infected = false;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    @Override
    public void update() {
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
