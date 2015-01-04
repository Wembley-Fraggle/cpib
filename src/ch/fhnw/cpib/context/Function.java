package ch.fhnw.cpib.context;

import ch.fhnw.cpib.lexing.ITerminal;

public final class Function extends Routine {

	public Function(final String ident, final ITerminal type) {
		super(ident, type, RoutineTypes.FUNCTION);
	}

}
