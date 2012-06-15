package main;

import Interfaces.IOutput;
import Interfaces.console.Console;
import Output.OutputConsole;

/**
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 * 
 * Main program, initiallizies the global configuration, sets the output device and starts the control console
 */
public class Main {

	static Console _myconsole = null;
	static Conf _globalConf = null;

	public static void main(String[] args) {
		_globalConf = new Conf();

		IOutput outputDevice = new OutputConsole(System.out);
		_globalConf.set_output(outputDevice);

		_myconsole = new Console(_globalConf);
	}

}
