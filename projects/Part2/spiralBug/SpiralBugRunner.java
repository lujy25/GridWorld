/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.awt.Color;


public class SpiralBugRunner
{
    public static void main(String[] args)
    {
//create a unbounded Grid
        ActorWorld world = new ActorWorld(new UnboundedGrid<Actor>());
        SpiralBug alice = new SpiralBug(4);
        alice.setColor(Color.ORANGE);
//set the origin location for the bug
        world.add(new Location(20, 20), alice);
        world.show();
    }
}