import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.TreeMap;
import java.util.Map;
public class SparseBoundedGrid3 extends UnboundedGrid<Actor> {
    private int rows;
    private int cols;
    private Map<Location, Actor> occupantMap;
    public SparseBoundedGrid3(int rows, int cols) {
	this.rows = rows;
	this.cols = cols;
	occupantMap = new TreeMap<Location, Actor>();
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
