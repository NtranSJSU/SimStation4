package SimStation;

import mvc.*;

/*
Date: 4/13/2024
Name: Nhat Tran
Update: Adding options for NE, NW, SE, SW
 */
public enum Heading {

    NORTH, SOUTH, EAST, WEST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST;

    public static Heading parse(String heading) {
        if (heading.equalsIgnoreCase("north")) return NORTH;
        if (heading.equalsIgnoreCase("south")) return SOUTH;
        if (heading.equalsIgnoreCase("east")) return EAST;
        if (heading.equalsIgnoreCase("west")) return WEST;
        if (heading.equalsIgnoreCase("northeast")) return NORTHEAST;
        if (heading.equalsIgnoreCase("northwest")) return NORTHWEST;
        if (heading.equalsIgnoreCase("southeast")) return SOUTHEAST;
        if (heading.equalsIgnoreCase("southwest")) return SOUTHWEST;
        Utilities.error("Invalid heading: " + heading);
        return null;
    }

    public static Heading random() {
        int luck = Utilities.rng.nextInt(8);
        if (luck == 0) return NORTH;
        if (luck == 1) return SOUTH;
        if (luck == 2) return EAST;
        if (luck == 3) return WEST;
        if (luck == 4) return NORTHEAST;
        if (luck == 5) return NORTHWEST;
        if (luck == 6) return SOUTHEAST;
        return SOUTHWEST;
    }
}
