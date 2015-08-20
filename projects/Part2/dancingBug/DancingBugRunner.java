/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.*;
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
	//the initail dancing step 
	Integer[] steps = new Integer[] {1,2,3,1,2,3,4,5,5,5,7,7,7,0};
//change the Integer[] into Arraylist
	DancingBug alice = new DancingBug(new ArrayList<Integer>(Arrays.asList(steps)));
        alice.setColor(Color.RED);
        world.add(new Location(4, 2),alice);
        world.show();
    }
}