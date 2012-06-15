package Interfaces.console;

import java.util.Arrays;
import java.util.logging.Level;

import logging.UseLogger;
import main.Conf;

/**
 * Subconsole for all log commands
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
public class LogListener extends AConsoleListener {
private String[] _possiblesLogs = null;
	public LogListener(Conf globalConf) {

		super(globalConf);

		initPossibleLogLevels();
	}

	/**
	 * Possible Log shades: FINEST, FINER, FINE, CONFIG, INFO, WARNING, SEVERE
	 */
	private void initPossibleLogLevels() {
		_possiblesLogs = new String[] { "OFF", "FINEST", "FINER", "FINE",
				"CONFIG", "INFO", "WARNING", "SEVERE", "ALL" };
	}

	/**
	 * @param loglevel loglevel to check
	 * @return	returns true if the given loglevel is valid
	 */
	public boolean isLogLevel(String loglevel) {
		return (Arrays.asList(_possiblesLogs).contains(loglevel));
	}

	/* (non-Javadoc)
	 * @see Interfaces.console.IConsoleListener#startListening(java.lang.String[])
	 */
	public void startListening(String[] input) {
		goingon = true;
		stringArray = input;
		while (goingon) {
			_myoutput.printLine("MAIN(LOG): ");

			if (stringArray.length == 0) {
				inputString = _in.nextLine().toUpperCase();
				stringArray = inputString.toUpperCase().split(" ");
			}

			/**
			 * if the input is LOG, just clear ist
			 */
			if (stringArray[0].equals(ConsoleCommands.LOG)) {
				stringArray = removeFirstCommand(stringArray);
				if (stringArray.length == 0)
					reinitializeStringArray();
			}

			if (stringArray[0].equals(ConsoleCommands.QUIT))
				goingon = false;

			else if (stringArray[0].equals(ConsoleCommands.HELP))
				getHelp();

			else if (stringArray[0].equals(ConsoleCommands.GET)) {
				getcurrentLogLevel();
				reinitializeStringArray();
			} else if (stringArray[0].equals(ConsoleCommands.SET)
					&& isLogLevel(stringArray[1])) {
				String logLevel = removeFirstCommand(stringArray)[0];
				setLogLevel(logLevel);
				stringArray = removeFirstCommand(stringArray);
			}

			else
				getHelp();

			stringArray = removeFirstCommand(stringArray);

		}
	}

	/**
	 * Logs the currently used loglevel 
	 */
	public void getcurrentLogLevel() {
		Conf.LOGSTRING = "The current Log Level is set to: " + getLogLevel();

		_myoutput.printLine(Conf.LOGSTRING);
		UseLogger.LOGGER.info(Conf.LOGSTRING);

	}

	/**
	 * @return	the current loglevel
	 */
	public String getLogLevel() {
		return UseLogger.LOGGER.getLevel().toString();
	}

	/**
	 * @param level	sets the current loglevel to level
	 */
	public void setLogLevel(String level) {

		try {
			UseLogger.LOGGER.setLevel(Level.parse(level));
		} catch (Exception e) {
			e.printStackTrace();
		}

		_myoutput.printLine("The log level has been set successfully to '"
				+ UseLogger.LOGGER.getLevel() + "' \n");

		goingon = false;
	}

	/* (non-Javadoc)
	 * @see Interfaces.console.IConsoleListener#getHelp()
	 */
	@Override
	public void getHelp() {
		if (!isLogLevel(stringArray[0]) || inputString.isEmpty()) {
			_myoutput.printLine("<<"
							+ makeStringArrayToString(stringArray)
							+ ">> is NOT a valid input. Please use one of the following inputs...\n");
		}

		_myoutput.printLine("SET OFF:\t\t turn the Log off.");
		_myoutput.printLine("SET FINEST:\t\t Log on the FINEST Log.");
		_myoutput.printLine("SET FINER:\t\t Log on the FINERI log.");
		_myoutput.printLine("SET FINER:\t\t Log on the FINE log.");
		_myoutput.printLine("SET INFO:\t\t Log an INFO message.");
		_myoutput.printLine("SET SEVERE:\t\t Log a SEVERE message..");
		_myoutput.printLine("SET ALL:\t\t Log all messages.");
		_myoutput.printLine("QUIT:\t\t go back to main menu.");
		_myoutput.printLine("GET:\t\t Gives back the current Log Level");

		reinitializeStringArray();

	}

	/* (non-Javadoc)
	 * @see Interfaces.console.IConsoleListener#getCommand()
	 */
	public String getCommand() {
		return "LOG";
	}

}