package Output;

import java.io.PrintStream;

import Interfaces.AOutput;

/**
 * This implements a console as output stream
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public class OutputConsole extends AOutput {

	/**
	 * @param sets console as the output stream
	 */
	public OutputConsole(PrintStream stream) {
		super(stream);
	}

}
