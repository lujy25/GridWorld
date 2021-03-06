/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/21
 */
package src;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.Color;
public class Jumper extends Bug
{
    public Jumper() {
	setColor(Color.GREEN);
    }
    public Jumper(Color jumperColor) {
	setColor(jumperColor);
    }
    public void move() {
	Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
	}
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
	if (!gr.isValid(next)) {
	    removeSelfFromGrid();
	    return;
	}
	Location next_next = next.getAdjacentLocation(getDirection());
        if (gr.isValid(next_next)) {
            moveTo(next_next);
	} else {
            removeSelfFromGrid();
	}
    }
    public boolean canMove() {
	Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
	}
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
	Location next_next = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(next_next))
            return false;
        Actor neighbor = gr.get(next_next);
        return (neighbor == null);
    }
   
    
}
