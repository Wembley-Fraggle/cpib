package ch.fhnw.cpib.context;

import ch.fhnw.cpib.parsing.ILiteralVal;

public final class Function extends Routine {

	public Function(final String ident, ILiteralVal.Type type) {
		super(ident, type, RoutineTypes.FUNCTION);
	}

}
