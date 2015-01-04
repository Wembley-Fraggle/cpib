package ch.fhnw.cpib.context;

import ch.fhnw.cpib.lexing.Terminal;

public class Procedure extends Routine {

	public Procedure(final String ident) {
		// FIXME
		super(ident, new Terminal("PROC"), RoutineTypes.PROCEDURE);
	}

}
