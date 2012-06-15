package ioInferface.gui;

import ch.aplu.jgamegrid.Actor;

/**
 * This class just shows a black dot in the maze
 * 
 * @author Micha Schoenenberger, Andreas Gruenenfelder
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
