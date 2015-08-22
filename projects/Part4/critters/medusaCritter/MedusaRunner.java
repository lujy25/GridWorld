package medusaCritter;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.awt.Color;
public class MedusaRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(30,30));
        world.add(new Location(7, 8), new Critter());
        world.add(new Location(3, 3), new Critter());
	world.add(new Location(6, 3), new Critter());
	world.add(new Location(3, 2), new Critter());
	world.add(new Location(3, 9), new Critter());
        world.add(new Location(2, 8), new Critter(Color.BLUE));
        world.add(new Location(5, 5), new Rock(Color.PINK));
        world.add(new Location(1, 5), new Rock(Color.RED));
        world.add(new Location(7, 2), new Rock(Color.YELLOW));
        world.add(new Location(5, 8), new MedusaCritter());
        world.show();
    }
}
