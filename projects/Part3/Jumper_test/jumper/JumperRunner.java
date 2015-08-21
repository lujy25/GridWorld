/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.grid.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import java.awt.Color;


public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

        Jumper alice = new Jumper();
        world.add(new Location(4, 1), alice);
        world.show();
    }
}