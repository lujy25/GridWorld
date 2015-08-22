package medusaCritter;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.Math.*;
public class MedusaCritter extends Critter
{
    private Actor prey = null;
    public MedusaCritter(Color color) {
	setColor(color);
    }
    public MedusaCritter() {
	setColor(Color.RED);
    }
    public void processActors(ArrayList<Actor> actors)
    {
	for (Actor actor : actors) {
	    if (actor == prey && actor != null) {
		Color color = actor.getColor();
		Location loc = actor.getLocation();
		actor.removeSelfFromGrid();
		Rock rock = new Rock(color);
		Grid gr = getGrid();
		rock.putSelfInGrid(gr,loc);
	    }
	}
    }
    private boolean searchPrey() {
	boolean exitPrey = false;
	if (prey == null || prey.getGrid() == null) {
	    Grid gr = getGrid();
	    ArrayList<Location> preyLocations = gr.getOccupiedLocations();
	    Collections.shuffle(preyLocations);
	    for (Location loc : preyLocations) {
		Actor actor = (Actor) gr.get(loc);
		if (!(actor instanceof Rock) && !(actor == this) && !(actor instanceof Flower)) {
		    prey = actor;
		    exitPrey = true;
		    break;
		}
	    }
	} else {
	    exitPrey = true;
	}
	return exitPrey;
    }
    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else
            moveTo(loc);
	if (prey != null && prey.getGrid() != null) {
	    setDirection(getLocation().getDirectionToward(prey.getLocation()));
	}
    }
    
    public Location selectMoveLocation(ArrayList<Location> locs)
    {

	if (searchPrey() == false || locs.size() == 0) {
	    return super.selectMoveLocation(locs);
	}
	Location currentLocation = getLocation();
	Location preyLocation = prey.getLocation();
	Collections.sort((List<Location>)locs, new SortByDirecion(currentLocation,preyLocation));
        return locs.get(0);
    }
}
class SortByDirecion implements Comparator{
    private Location currentLocation = null;
    private Location preyLocation = null;
    public SortByDirecion(Location current, Location prey) {
	currentLocation = current;
	preyLocation = prey;
    }
    public int compare(Object o1, Object o2) {
	Location l1 = (Location) o1;
	Location l2 = (Location) o2;
	int l1_degree = Math.abs(currentLocation.getDirectionToward(l1) - currentLocation.getDirectionToward(preyLocation));
	int l2_degree = Math.abs(currentLocation.getDirectionToward(l2) - currentLocation.getDirectionToward(preyLocation));
	return l1_degree - l2_degree;
    }
}
	
	
