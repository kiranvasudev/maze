package algorithms.generation.solve;

import labyrinth.Cell;
import labyrinth.Maze;
import main.Conf;
import algorithms.generation.Algorithms;

/**
 * This class defines the behavior of all solving algorithms
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
abstract public class ASolvingAlgorithms extends Algorithms implements
		ISolvingAlgorithms {
	/**
	 * Constructor for all Solving Algorithms.
	 */
	public ASolvingAlgorithms(Maze maze, Cell startCell, Cell endCell,
			Conf configs) {
		super(maze);
		_globalConf = configs;
		_startCell = startCell;
		_endCell = endCell;
	}

	/**
	 * gives the specificied Class of the Algoritm. The extended Class is always
	 * Algorithms
	 */
	public Class<? extends ASolvingAlgorithms> getInstance(String name) {
		return this.getClass();
	}

}
