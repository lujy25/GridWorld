package blusterCritter;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.util.ArrayList;
import java.awt.Color;

public class BlusterCritter extends Critter
{
    private static final double DARKENING_FACTOR = 0.05;
    private static final int MAX_RGB_NUMBER = 255;
    private int dark_brighter_factor;
    public BlusterCritter(int factor) {
	dark_brighter_factor = factor;
    }
    public BlusterCritter() {
	dark_brighter_factor = 3;
    }
    //return all of the neighbors within two steps of its current location
    public ArrayList<Actor> getActors() {
	ArrayList<Actor> actors = new ArrayList<Actor>();
	Grid gr = getGrid();
	Location loc = getLocation();
	ArrayList<Actor> oneStepActors = gr.getNeighbors(getLocation());
	actors.addAll(oneStepActors);
	for (Actor oneStep : oneStepActors) {
	    ArrayList<Actor> twoStepActors = gr.getNeighbors(oneStep.getLocation());
	    for (Actor twoStep : twoStepActors) {
		if (!actors.contains(twoStep) && (twoStep != this)) {
		    actors.add(twoStep);
		}
	    }
	};
	return actors;
    }
    private void dark() {
	Color color = getColor();
	int red = (int) (color.getRed() * (1 - DARKENING_FACTOR));
	int green = (int) (color.getGreen() * (1 - DARKENING_FACTOR));
	int blue = (int) (color.getBlue() * (1 - DARKENING_FACTOR));
	setColor(new Color(red, green, blue));
    }
    private void bright() {
	Color color = getColor();
	int red = (int) (color.getRed() * (1 + DARKENING_FACTOR));
	int green = (int) (color.getGreen() * (1 + DARKENING_FACTOR));
	int blue = (int) (color.getBlue() * (1 + DARKENING_FACTOR));
	if (red <= MAX_RGB_NUMBER && green <= MAX_RGB_NUMBER && blue <= MAX_RGB_NUMBER) {
	    setColor(new Color(red, green, blue));
	}
    }
    public void processActors(ArrayList<Actor> actors) {
	if (actors.size() < dark_brighter_factor) {
	    dark();
	} else {
	    bright();
	}
    }
   
}
