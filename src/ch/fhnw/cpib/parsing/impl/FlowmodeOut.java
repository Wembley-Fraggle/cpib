package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFlowmode;

public class FlowmodeOut implements IFlowmode {

    private IToken outMode;
    public FlowmodeOut(IToken outMode) {
        this.outMode = outMode;
    }
		@Override
		public String toString(String indent) {
			return indent + outMode.getValue() + '\n';
		}
		@Override
		public Modes getMode() {
			return Modes.OUT;
		}

}
