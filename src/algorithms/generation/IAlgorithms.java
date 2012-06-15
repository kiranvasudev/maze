package algorithms.generation;

/**
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 *
 * This Interface defines the behaviour of all Algorithms
 */
public interface IAlgorithms {

	/**
	 * @param name	Instance Name
	 * @return Class of given Instance
	 */
	public Class<? extends Algorithms> getInstance(String name);
	
}
