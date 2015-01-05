package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMechmode;

public class MechmodeRef implements IMechmode {

	private IToken mechmodeRef;

	public MechmodeRef(IToken mechmodeRef) {
		this.mechmodeRef = mechmodeRef;
	}

	@Override
	public String toString(String indent) {
		return indent + mechmodeRef.getValue() + '\n';
	}

	@Override
	public Modes getMode() {
		return Modes.REF;
	}
}
