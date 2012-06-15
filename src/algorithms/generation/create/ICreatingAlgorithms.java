package algorithms.generation.create;

/**
 * this is the interface for all creating Algorithms
 * 
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 * 
 */
public interface ICreatingAlgorithms {

	/**
	 * Creates the maze with the class' algorithm 
	 */
	public void createMaze();

	/**
	 * @return returns the algorithm's name
	 */
	public String getName();
}
