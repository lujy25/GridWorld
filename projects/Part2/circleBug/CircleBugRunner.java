/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;


public class CircleBugRunner
{
//program entrance 
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
//set the circle's diameter
        CircleBug alice = new CircleBug(4);
        alice.setColor(Color.ORANGE);
        world.add(new Location(6, 0), alice);
//show the world
        world.show();
    }
}