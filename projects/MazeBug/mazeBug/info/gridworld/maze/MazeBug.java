package info.gridworld.maze;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Comparator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;  
import java.util.TreeMap; 
public class MazeBug extends Bug {
    public Location next;
    public Location last;
    public boolean isEnd = false;
    public Stack<Location> crossLocation = new Stack<Location>();
    public Integer stepCount = 0;
    private Map<Integer, Integer> dirStep;
    private boolean hasShown = false;//final message has been shown
    private HashSet<Location> hasVisited;
    /**
     * Constructs a box bug that traces a square of a given side length
     * 
     * @param length
     *            the side length
     */
    public MazeBug() {
	setColor(Color.GREEN);
	last = new Location(0, 0);
	Location loc = getLocation();
	hasVisited = new HashSet<Location>();
	hasVisited.add(loc);
	dirStep = new TreeMap<Integer, Integer>();
	for (int dir = 0 ; dir < Location.FULL_CIRCLE ; ++dir) {
	    dirStep.put(dir,1);
	}
    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
	boolean willMove = canMove();
	if (isEnd == true) {
	    //to show step count when reach the goal		
	    if (hasShown == false) {
		String msg = stepCount.toString() + " steps";
		JOptionPane.showMessageDialog(null, msg);
		hasShown = true;
	    }
	} else if (willMove) {
	    move();
	    //increase step count when move 
	    stepCount++;
	} 
    }

    /**
     * Find all positions that can be move to.
     * 
     * @param loc
     *            the location to detect.
     * @return List of positions.
     */
    private boolean isEmptyCell(Location loc) {
	Grid<Actor> gr = getGrid();
	return gr.isValid(loc) && !(gr.get(loc) instanceof Rock);
    }
    private ArrayList<Location> getNeighborLocations(Location loc) {
	ArrayList<Location> locs = new ArrayList<Location>();
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return null;
	int[] dirs = 
	    {Location.LEFT, Location.RIGHT, Location.HALF_CIRCLE, Location.FULL_CIRCLE};
	for (int d : dirs) {
	    Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	    if (gr.isValid(neighborLoc)) {
		locs.add(neighborLoc);
	    }
	}
	return locs;
    }
		 
    public ArrayList<Location> getValid(Location loc) {
	ArrayList<Location> valid = new ArrayList<Location>();
	ArrayList<Location> neighborLocs = getNeighborLocations(loc);
	for (Location neighborLoc : neighborLocs) {
	    if (isEmptyCell(neighborLoc) && !hasVisited.contains(neighborLoc)) {
		valid.add(neighborLoc);
	    }
	}  
	return valid;
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * 
     * @return true if this bug can move.
     */
    public boolean canMove() {
	Location loc = getLocation();
	Grid<Actor> gr = getGrid();
	ArrayList<Location> neighborLocs = getNeighborLocations(loc);
	for (Location neighborLoc : neighborLocs) {
	    if (gr.get(neighborLoc) != null && gr.get(neighborLoc).getColor().equals(Color.RED)) {
		isEnd = true;
		return false;
	    }
	}
	ArrayList<Location> locs = getValid(loc);
	return locs.size() > 0 || !crossLocation.empty();
    }
    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move() {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return;
	Location loc = getLocation();
	ArrayList<Location> locs = getValid(loc);
	int moveDirection;
	if (locs.size() > 0) {
	    next = selectMoveLocation(locs);
	    moveDirection = loc.getDirectionToward(next);
	    dirStep.put(moveDirection, dirStep.get(moveDirection) + 1);
	    crossLocation.push(loc);
	} else if (!crossLocation.empty()){
	    next = crossLocation.peek();
	    moveDirection = next.getDirectionToward(loc);
	    dirStep.put(moveDirection, dirStep.get(moveDirection) - 1);
	    crossLocation.pop();
	} else {
	    removeSelfFromGrid();
	    return;
	}
	hasVisited.add(next);
	setDirection(getLocation().getDirectionToward(next));
	moveTo(next);
	Flower flower = new Flower(getColor());
	flower.putSelfInGrid(gr, loc);
    }
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
	Collections.sort(dirStep, new Comparator<Map.Entry<Integer, Integer>>() {
		public int compara(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) {
		    return obj1.getValue() > obj2.getValue();
		}
	    });
	int n = locs.size();
	if (n == 0) {
	    return getLocation();
	}    
	int r = (int) (Math.random() * n);
	return locs.get(r);
    }
}
