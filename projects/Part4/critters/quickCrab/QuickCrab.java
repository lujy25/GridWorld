package quickCrab;
import crabCritter.CrabCritter;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
public class QuickCrab extends CrabCritter
{

    /**
     * A QuickCrab moves to one of the two locations, randomly selected, that are two spaces to its right or left, if that location and the intervening location are both empty. 
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
	Location currentLocation = getLocation();
	Grid gr = getGrid();
	for (int dir : dirs) {
	    Location oneStep = currentLocation.getAdjacentLocation(getDirection() + dir);
	    if (gr.isValid(oneStep) && gr.get(oneStep) == null) {
		Location twoStep = oneStep.getAdjacentLocation(getDirection() + dir);
		if (gr.isValid(twoStep) && gr.get(twoStep) == null) {
		    locs.add(twoStep);
		}
	    } else if (gr.isValid(oneStep) && gr.get(oneStep) == null) {
		locs.add(oneStep);
	    }
	}
	
	return locs;
    }

}
