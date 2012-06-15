package Interfaces.console;

import main.Conf;

/**
 * Subconsole for all Modus commands
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public class ModusListener extends AConsoleListener {

	/**
	 * @param globalConf	global Configuration Handler
	 */
	public ModusListener(Conf globalConf) {
		super(globalConf);

	}

	/* (non-Javadoc)
	 * @see Interfaces.console.IConsoleListener#startListening(java.lang.String[])
	 */
	public void startListening(String[] input) {
		goingon = true;
		stringArray = input;
		String modusString = null;

		while (goingon) {
			_myoutput.print("MAIN(MODUS): ");

			if (stringArray.length == 0) {
				inputString = _in.nextLine().toUpperCase();
				stringArray = inputString.toUpperCase().split(" ");
			}

			if (stringArray[0].equals(ConsoleCommands.SET)) {
				_myoutput.printLine(stringArray[1]);
				if (stringArray[1].equals(ConsoleCommands.STEP))
					_globalConf.setStepModus(true);
				if (stringArray[1].equals(ConsoleCommands.RUN))
					_globalConf.setStepModus(false);
				goingon = false;
			}

			if (stringArray[0].equals(ConsoleCommands.GET)) {
				if (_globalConf.isStepModus()) {
					modusString = "STEP";
					goingon = false;
				} else {
					modusString = "RUN";
					goingon = false;
				}
				_myoutput.printLine("The current MODUS is : " + modusString);
			}
			if (stringArray[0].equals(ConsoleCommands.QUIT))
				goingon = false;
			
			else if (stringArray[0].equals(ConsoleCommands.HELP)
					|| stringArray.length == 0 || !isvalidInput())
				getHelp();

			stringArray = new String[] {};

		}
	}

	/* (non-Javadoc)
	 * @see Interfaces.console.IConsoleListener#getHelp()
	 */
	@Override
	public void getHelp() {
		if (inputString.isEmpty()
				|| !stringArray[0].equals(ConsoleCommands.HELP)) {

			_myoutput
					.printLine("<<"
							+ makeStringArrayToString(stringArray)
							+ ">> is NOT a valid input. Please use one of the following inputs...\n");

		}
		_myoutput
				.printLine(ConsoleCommands.SET
						+ " "
						+ ConsoleCommands.STEP
						+ ":\t changes the modus to STEP. This means every step will be shown.");
		_myoutput
				.printLine(ConsoleCommands.SET
						+ " "
						+ ConsoleCommands.RUN
						+ ":\t changes the modus to RUN. This means just the result will be shown.");
		_myoutput.printLine(ConsoleCommands.GET
				+ ":\t\t will show you the current Modus");

		_myoutput.printLine(ConsoleCommands.QUIT
				+ ":\t\t go back to main menu.");
		goingon = true;
		reinitializeStringArray();
	}

	/**
	 * @return	true if input is valid, false if invalid
	 */
	private boolean isvalidInput() {

		if (stringArray[0].equals(ConsoleCommands.GET))
			return true;
		if (stringArray[0].equals(ConsoleCommands.SET)) {

			if (stringArray[1].equals(ConsoleCommands.STEP))
				return true;
			if (stringArray[1].equals(ConsoleCommands.RUN))
				return true;

		}

		return false;
	}

	/* (non-Javadoc)
	 * @see Interfaces.console.IConsoleListener#getCommand()
	 */
	@Override
	public String getCommand() {
		return "MODUS";
	}

}