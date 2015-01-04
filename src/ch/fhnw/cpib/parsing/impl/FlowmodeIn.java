package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFlowmode;

public class FlowmodeIn implements IFlowmode {

	private IToken inMode;

	public FlowmodeIn(IToken inMode) {
		this.inMode = inMode;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IToken getMode() {
		return inMode;
	}

}
