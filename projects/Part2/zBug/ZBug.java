/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
 //recorde the state whether the bug complement the 'z' painting
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
//encounter something or paint complemently,stop
	    ;
	} else {
	    switch(this.getDirection()) {
	    case Location.EAST:
;//change the direction for painting 'z'
		this.setDirection(Location.SOUTHWEST)
		break;
	    case Location.SOUTHWEST:
//change the direction for painting 'z'
		this.setDirection(Location.EAST);
		paintOk = true;
		break;
	    
	    }
            steps = 0;
        }
    }
}
