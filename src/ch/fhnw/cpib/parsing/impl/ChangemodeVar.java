package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.as.IAbsExpr2;

public class ChangemodeVar implements IChangemode {

	private IToken changemodeVar;

	public ChangemodeVar(IToken changemodeVar) {
		this.changemodeVar = changemodeVar;
	}

	public IAbsExpr2 toAbsSyn(IAbsExpr2 e) {
		return e;
	}
}
