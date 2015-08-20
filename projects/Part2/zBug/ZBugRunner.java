/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.grid.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;


public class ZBugRunner
{
//program entrance 
    public static void main(String[] args)
    {
//create a world for the zBug to run
        ActorWorld world = new ActorWorld();

        ZBug alice = new ZBug(4);
        alice.setColor(Color.ORANGE);
//set origin location
        world.add(new Location(4, 1), alice);
        world.show();
    }
}