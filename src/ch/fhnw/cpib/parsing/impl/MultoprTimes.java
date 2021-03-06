package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IMultopr;

public class MultoprTimes implements IMultopr {

    private IToken times;
    public MultoprTimes(IToken times) {
        this.times = times;
    }
    
    @Override
    public IToken toAbsSyn() {
        return times;
    }

		@Override
		public String toString(String indent) {
			return indent + "<MULTOPR>" + times.getValue() + "</MULTOPR>\n";
		}

}
