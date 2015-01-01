package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFlowmode;

public class FlowmodeOut implements IFlowmode {

    private IToken outMode;
    public FlowmodeOut(IToken outMode) {
        this.outMode = outMode;
    }

}
