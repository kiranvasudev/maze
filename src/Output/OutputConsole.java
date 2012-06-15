package Output;

import java.io.PrintStream;

import Interfaces.AOutput;

/**
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 *
 * This implements a console as output stream
 */
public class OutputConsole extends AOutput {

	/**
	 * @param sets console as the output stream
	 */
	public OutputConsole(PrintStream stream) {
		super(stream);
	}

}
