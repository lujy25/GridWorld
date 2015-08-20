import info.gridworld.grid.*;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.awt.Color;


public class SpiralBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new UnboundedGrid<Actor>());
        SpiralBug alice = new SpiralBug(4);
        alice.setColor(Color.ORANGE);
        world.add(new Location(20, 20), alice);
        world.show();
    }
}