package algorithms.generation;

/**
 * This Interface defines the behaviour of all Algorithms
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public interface IAlgorithms {

	/**
	 * @param name	Instance Name
	 * @return Class of given Instance
	 */
	public Class<? extends Algorithms> getInstance(String name);
	
}
