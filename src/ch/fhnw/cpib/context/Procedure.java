package ch.fhnw.cpib.context;

import ch.fhnw.cpib.parsing.ILiteralVal;

public class Procedure extends Routine {

	public Procedure(final String ident) {
		super(ident,ILiteralVal.Type.PROC, RoutineTypes.PROCEDURE);
	}

}
