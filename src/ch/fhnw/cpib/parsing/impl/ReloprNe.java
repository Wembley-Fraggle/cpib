package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IRelopr;

public class ReloprNe implements IRelopr {

    private IToken ne;
    public ReloprNe(IToken ne) {
        this.ne = ne;
    }
    @Override
    public IToken toAbsSyn() {
       return ne;
    }
		@Override
		public String toString(String indent) {
			return indent + "<RELOPR>" + ne.getValue() + "</RELOPR>\n";
		}

}
