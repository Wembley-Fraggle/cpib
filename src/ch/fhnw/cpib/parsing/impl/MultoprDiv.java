package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMultopr;

public class MultoprDiv implements IMultopr {

    private IToken div;

    public MultoprDiv(IToken div) {
        this.div = div;
    }

    @Override
    public IToken toAbsSyn() {
       return div;
    }

		@Override
		public String toString(String indent) {
			return indent + "<MULTOPR>" + div.getValue() + "</MULTOPR>\n";
		}

}
