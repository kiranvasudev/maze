package ioInferface.gui;

import ch.aplu.jgamegrid.Actor;

/**
 * This Cell class is a faked cell class. The used Frameword JGramgrid gives the
 * possibilities of an actor in a GUI. So the cell of the maze is an actor which
 * just use a black background.
 * 
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 * 
 */
class Wall extends Actor {

	/**
	 * creates a wall 
	 */
	public Wall() {
		super(true, "sprites/black_background_22.png");
		this.setCollisionImage();
	}
}
