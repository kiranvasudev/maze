package algorithms.generation.solve;

/**
 * This interface describes the behavior of all solving algorithms
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public interface ISolvingAlgorithms {

	/**
	 * This method resolves the maze with the instanced algorithm
	 */
	public void resolveMaze();
	
	/**
	 * Returns the name of the solving algorithm
	 * 
	 * @return	solving algorithm name
	 */
	public String getName();

}
