package medusaCritter;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
public class MedusaRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20,20));
        world.add(new Location(7, 8), new Critter());
        world.add(new Location(3, 3), new Bug(Color.BLUE));
	world.add(new Location(14,14),new Bug(Color.RED));
	world.add(new Location(0,14),new Bug(Color.PINK));
	world.add(new Location(6, 3), new Actor());
	world.add(new Location(3, 2), new Bug(Color.WHITE));
	world.add(new Location(3, 9), new Critter());
        world.add(new Location(2, 8), new Critter());
	world.add(new Location(16, 8), new Critter());
	world.add(new Location(9, 15), new Critter());
	world.add(new Location(12, 6), new Bug());
        world.add(new Location(5, 5), new Rock(Color.PINK));
        world.add(new Location(1, 5), new Rock(Color.RED));
        world.add(new Location(7, 2), new Rock(Color.YELLOW));
        world.add(new Location(5, 8), new MedusaCritter(Color.GREEN));
	world.add(new Location(16, 8), new MedusaCritter(Color.YELLOW));
	world.add(new Location(5, 15), new MedusaCritter(Color.BLACK));
	world.add(new Location(15, 15), new MedusaCritter(Color.GRAY));
	world.add(new Location(8, 13), new MedusaCritter(Color.PINK));
        world.show();
    }
}
