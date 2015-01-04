package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IChangemode;

public class ChangemodeConst implements IChangemode {

	private IToken constMode;

	public ChangemodeConst(IToken constMode) {
		this.constMode = constMode;
	}

	public IAbsExpr2 toAbsSyn(IAbsExpr2 e) {
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
