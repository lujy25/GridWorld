import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private boolean paintOk; 
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
	paintOk = false;
	this.setDirection(Location.EAST);
    }

    public void act()
    {
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        } else if (!canMove() || paintOk) {
	    ;
	} else {
	    switch(this.getDirection()) {
	    case Location.EAST:
		this.setDirection(Location.SOUTHWEST);
		break;
	    case Location.SOUTHWEST:
		this.setDirection(Location.EAST);
		paintOk = true;
		break;
	    
	    }
            steps = 0;
        }
    }
}
