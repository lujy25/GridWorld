package kingCrab;
import crabCritter.CrabCritter;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;


public class KingCrab extends CrabCritter
{
    public void processActors(ArrayList<Actor> actors)
    {
	ArrayList<Location> attackLocations = getAttackLocations();
        for (Actor actor : actors) {
	    boolean canEscape = false;
	    Location orginLocation = actor.getLocation();
	    ArrayList<Location> escapeLocations = actor.getGrid().getEmptyAdjacentLocations(orginLocation);
	    for (Location loc : escapeLocations) {
		if (!attackLocations.contains(loc)) {
		    actor.moveTo(loc);
		    canEscape = true;
		    break;
		}
	    }
	    if (canEscape == false) {
		actor.removeSelfFromGrid();
	    }
	}
    }
    public ArrayList<Location> getAttackLocations() {
	ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().isValid(loc))
                locs.add(loc);

        return locs;
    }

}
