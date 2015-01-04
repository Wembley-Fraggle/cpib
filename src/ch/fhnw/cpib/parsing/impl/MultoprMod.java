package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMultopr;

public class MultoprMod implements IMultopr {
    private IToken mod;

    public MultoprMod(IToken mod) {
        this.mod = mod;
    }

    @Override
    public IToken toAbsSyn() {
       return mod;
    }

		@Override
		public String toString(String indent) {
			return indent + "<MULTOPR>" + mod.getValue() + "</MULTOPR>\n";
		}
}
