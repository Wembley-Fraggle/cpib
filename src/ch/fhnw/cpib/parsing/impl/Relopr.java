package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IRelopr;

public class Relopr implements IRelopr {

    private IToken eq;
    public Relopr(IToken eq) {
        this.eq = eq;
    }
    
    @Override
    public IToken toAbsSyn() {
        return eq;
    }

		@Override
		public String toString(String indent) {
			return indent + "<RELOPR>" + eq.getValue() + "</RELOPR>\n";
		}

}
