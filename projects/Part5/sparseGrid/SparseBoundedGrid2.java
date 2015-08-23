import info.gridworld.actor.*;
import info.gridworld.grid.*;
public class SparseBoundedGrid2 extends UnboundedGrid<Actor> {
    private int rows;
    private int cols;
    public SparseBoundedGrid2(int rows, int cols) {
	super();
	this.rows = rows;
	this.cols = cols;
    }
    public int getNumRows() {
	return this.rows;
    }
    public int getNumCols() {
	return this.cols;
    }
    public boolean isValid(Location loc) {
	return 0 <= loc.getRow() && loc.getRow() < getNumRows()
	    && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
}
