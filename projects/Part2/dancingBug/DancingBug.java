/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.actor.Bug;
import java.util.*;
public class DancingBug extends Bug
{
    private List<Integer> dancingSteps;
//record the index the dancing step now should show
    private int cursor;
    public DancingBug(List<Integer> steps)
    {
        dancingSteps = steps;
	cursor = 0;
    }
    //add new step for the dancingStep
    public void addDancingStep(Integer step) {
	dancingSteps.add(step);
    }
    public void act()
    {
//don't complete,show the next step
        if (cursor < dancingSteps.size()) {
	    this.setDirection(45 * dancingSteps.get(cursor));
	    ++cursor;
	} else {
	    cursor = 0;
	    //set the new direction for the dancingStep
	    this.setDirection(45 * dancingSteps.get(cursor));
	    ++cursor;
	}
//move like the common bug
	if (canMove()) {
	    move();
	} else {
	    turn();
	}
    }
}
