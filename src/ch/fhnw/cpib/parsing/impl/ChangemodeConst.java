package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IChangemode;

public class ChangemodeConst implements IChangemode {

	private IToken constMode;

	public ChangemodeConst(IToken constMode) {
		this.constMode = constMode;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + constMode.getValue() + '\n';
	}

	@Override
	public Modes getMode() {
		return Modes.CONST;
	}
}
