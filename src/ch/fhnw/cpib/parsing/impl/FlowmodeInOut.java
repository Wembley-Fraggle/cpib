package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFlowmode;

public class FlowmodeInOut implements IFlowmode {

    private IToken inOutMode;
    
    public FlowmodeInOut(IToken inOutMode) {
        this.inOutMode = inOutMode;
    }

}
