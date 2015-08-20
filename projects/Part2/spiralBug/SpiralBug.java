/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.actor.Bug;
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;
    public SpiralBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
//increase the steps the record the step the bug run
            steps++;
        }
        else
        {
            turn();
	    turn();
	    //refresh the steps for the new direction
            steps = 0;
//increase the sideLength so that the bug will move into a bigger square
	    sideLength += 1;
        }
    }
}
