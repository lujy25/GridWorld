package chameleonKid;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.util.ArrayList;
import java.awt.Color;
import chameleonCritter.ChameleonCritter;

public class ChameleonKid  extends ChameleonCritter
{

    //return the actors in front or behind it
    public ArrayList<Actor> getActors() {
	ArrayList<Actor> actors = new ArrayList<Actor>();
	Grid gr = getGrid();
	Location loc = getLocation();
	Location fontLocation = loc.getAdjacentLocation(getDirection());
	Location  behindLocation = loc.getAdjacentLocation(getDirection() + Location.HALF_CIRCLE);
	if (getGrid().isValid(fontLocation) && getGrid().get(fontLocation) != null) {
	    actors.add(getGrid().get(fontLocation));
	}
	if (getGrid().isValid(behindLocation) && getGrid().get(behindLocation) != null) {
	    actors.add(getGrid().get(behindLocation));
	}
	return actors;
    }
}
