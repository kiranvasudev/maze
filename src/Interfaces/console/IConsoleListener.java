package Interfaces.console;

/**
 * This interface describes the behavior of all any console
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public interface IConsoleListener {

	/**
	 * prints the help message
	 */
	public void getHelp();

	/**
	 * basically clears the string array (e.g. the input)
	 */
	public void reinitializeStringArray();

	/**
	 * @param args input string array
	 * @return returns the string array w/o the first word (e.g. the command)
	 */
	public String[] removeFirstCommand(String[] args);

	/**
	 * @return the Command of the Class (e.g. SOLVE for the solveListener)
	 */
	public String getCommand();

	/**
	 * @param input input array 
	 */
	public void startListening(String[] input);

}
