package ioInferface.gui;

import ch.aplu.jgamegrid.Actor;

/**
 * This class just shows a blue dot in the maze
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public class BlueDot extends Actor {

	/**
	 * This class just shows a black blue in the maze 
	 */
	public BlueDot() {
		super(true,"sprites/blue_dot.png");
		this.setCollisionImage();
	}
}
