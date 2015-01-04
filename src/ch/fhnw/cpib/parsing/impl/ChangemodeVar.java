package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IChangemode;

public class ChangemodeVar implements IChangemode {

	private IToken changemodeVar;

	public ChangemodeVar(IToken changemodeVar) {
		this.changemodeVar = changemodeVar;
	}
}
