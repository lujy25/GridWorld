/*
 *Copyright(c) 
 *@author lujianye
 *@date 2015/08/20
 */
import info.gridworld.actor.Bug;
public class CircleBug extends Bug
{
//recorde the step move in the same way
    private int steps;
//decide the longest distance move in the same way
    private int sideLength;

    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
//turn 45 degree to move like a circle
            turn();
//refresh the steps for the new direction
            steps = 0;        }
    }
}
