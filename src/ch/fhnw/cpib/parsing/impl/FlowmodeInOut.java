package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFlowmode;

public class FlowmodeInOut implements IFlowmode {

    private IToken inOutMode;
    
    public FlowmodeInOut(IToken inOutMode) {
        this.inOutMode = inOutMode;
    }

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + inOutMode.getValue() + '\n';
	}

	@Override
	public Modes getMode() {
		return return Modes.INOUT;
	}

}
