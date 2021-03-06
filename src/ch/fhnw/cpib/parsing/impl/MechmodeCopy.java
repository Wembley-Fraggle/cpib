package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMechmode;

public class MechmodeCopy implements IMechmode {

    private IToken copy;
    public MechmodeCopy(IToken copy) {
        this.copy = copy;
    }
	@Override
	public String toString(String indent) {
		return indent + copy.getValue() + '\n';
	}
	
	@Override
	public Modes getMode() {
		return Modes.COPY;
	}

}
