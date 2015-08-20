import info.gridworld.grid.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.*;
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
	Integer[] steps = new Integer[] {3,5,7,0,2,4,7,4,1};
	DancingBug alice = new DancingBug(new ArrayList<Integer>(Arrays.asList(steps)));
        alice.setColor(Color.ORANGE);
        world.add(new Location(4, 3), alice);
        world.show();
    }
}