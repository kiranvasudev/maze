package algorithms.generation.solve;

/**
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 *
 * This interface describes the behavior of all solving algorithms
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
