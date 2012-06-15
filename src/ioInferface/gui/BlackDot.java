package ioInferface.gui;

import ch.aplu.jgamegrid.Actor;

/**
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 * 
 * This class just shows a black dot in the maze
 */
public class BlackDot extends Actor{

	/**
	 * This class just shows a black dot in the maze. 
	 */
	public BlackDot() {
		super(true, "sprites/black_dot.png");
		
		this.setCollisionImage();
	}
}
