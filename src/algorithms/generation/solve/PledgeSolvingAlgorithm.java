package algorithms.generation.solve;

import labyrinth.Cell;
import labyrinth.Maze;
import main.Conf;


/**
 * NOT YET IMPLEMENTED 
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public class PledgeSolvingAlgorithm extends ASolvingAlgorithms {

	/**
	 * @param maze	Maze
	 * @param startCell	Start Cell
	 * @param endCell End Cell
	 * @param configs Global configuration handler 
	 */
	public PledgeSolvingAlgorithm(Maze maze, Cell startCell, Cell endCell, Conf configs) {
		super(maze, startCell, endCell, configs);
	}

	/* (non-Javadoc)
	 * @see algorithms.generation.solve.ISolvingAlgorithms#resolveMaze()
	 */
	@Override
	public void resolveMaze() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see algorithms.generation.solve.ISolvingAlgorithms#getName()
	 */
	@Override
	public String getName() {
		return "PLEDGE";
	}
}
