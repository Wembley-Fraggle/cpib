package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class ChangemodeConst implements IChangemode {

	private IToken constMode;

	public ChangemodeConst(IToken constMode) {
		this.constMode = constMode;
	}

	public IAbsExpr toAbsSyn(IAbsExpr e) {
		return e;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IToken getMode() {
		return constMode;
	}
}
