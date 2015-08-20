import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.util.ArrayList;
public class DancingBug extends Bug
{
    private ArrayList<Integer> dancingSteps;
    private int cursor;
    public DancingBug(ArrayList<Integer> steps)
    {
        dancingSteps = steps;
	cursor = 0;
    }
    public void addDancingStep(Integer step) {
	dancingSteps.add(step);
    }
    public void turn()
    {
        if (cursor < dancingSteps.size()) {
	    this.setDirection(45 * dancingSteps.get(cursor));
	    ++cursor;
	} else {
	    cursor = 0;
	    this.setDirection(45 * dancingSteps.get(cursor));
	}
    }
}
