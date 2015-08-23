import java.util.ArrayList;
import java.util.*;
import info .gridworld.actor.*;
import info.gridworld.grid.*;
public class UnboundedGrid2 extends AbstractGrid<Actor>
{
    private ArrayList<ArrayList> occupantArray;
    //recorder the current really row and col
    int current_row;
    int current_col;
    public UnboundedGrid2() {
	current_row = current_col = 16;
	occupantArray = new ArrayList<ArrayList>();
	for(int r = 0 ; r < current_row ; ++r) {
	    ArrayList<Actor> rowOccupants = new ArrayList<Actor>();
	    for(int c = 0 ; c < current_col; ++c) {
		rowOccupants.add(null);
	    }
	    occupantArray.add(rowOccupants);
	}

    }

    public int getNumRows() {
        return -1;
    }

    public int getNumCols() {
        return -1;
    }
    private int getRealNumRows() {
	return current_row;
    }
    private int getRealNumCols() {
	return current_col;
    }
    public boolean isValid(Location loc) {
        return loc.getCol() >= 0 && loc.getRow() >= 0;
    }

    public ArrayList<Location> getOccupiedLocations() {
	ArrayList<Location> theLocations = new ArrayList<Location>();
        // Look at all grid locations.
        for (int r = 0; r < getRealNumRows(); r++) {
	    for (int c = 0; c < getRealNumCols(); c++) {
		// If there's an object at this location, put it in the array.
		Location loc = new Location(r, c);
		if (get(loc) != null)
		    theLocations.add(loc);
	    }
	}
	return theLocations;
    }

    public Actor get(Location loc) {
        if (loc == null)
            throw new NullPointerException("loc == null");
	if (loc.getRow() >= getRealNumRows() || loc.getCol() >= getRealNumCols()) {
	    return null;
	}
	ArrayList<Actor> rowOccupants = occupantArray.get(loc.getRow());
        return rowOccupants.get(loc.getCol());
    }

    public Actor put(Location loc, Actor obj)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        if (obj == null)
            throw new NullPointerException("obj == null");
	while (loc.getRow() >= getRealNumRows() || loc.getCol() >= getRealNumCols()) {
	    doubleArraySize();
	}
	Actor oldOccupant = get(loc);
	occupantArray.get(loc.getRow()).remove(loc.getCol());
	occupantArray.get(loc.getRow()).add(loc.getCol(),obj);
	return oldOccupant;
    }

    public Actor remove(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
	Actor oldOccupant = get(loc);
	occupantArray.get(loc.getRow()).remove(loc.getCol());
	occupantArray.get(loc.getRow()).add(loc.getCol(),null);
        return oldOccupant;
    }
    public void doubleArraySize() {
	int oldRowNumber = getRealNumRows();
	int oldColNumber = getRealNumCols();
	current_row *= 2;
	current_col *= 2;
	//supply the old row
	for (int r = 0 ; r < oldRowNumber ; ++r) {
	    for (int c = 0 ; c < oldColNumber ; ++c) {
		occupantArray.get(r).add(null);
	    }
	}
	//add the new rows
	for (int r = oldRowNumber ; r < current_row ; ++r) {
	    ArrayList<Actor> rowOccupants = new ArrayList<Actor>();
	    for (int c = 0 ; c < current_col ; ++c) {
		rowOccupants.add(null);
	    }
	    occupantArray.add(rowOccupants);
	}
    }
}