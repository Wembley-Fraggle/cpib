package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAddopr;

public class AddoprMinus implements IAddopr {

    private IToken minusOpr;
    public AddoprMinus(IToken minusOpr) {
        this.minusOpr = minusOpr;
    }
    
    @Override
    public IToken toAbsSyn() {
       return minusOpr;
    }

		@Override
		public String toString(String indent) {
			return indent + "<ADDOPR>\n" + minusOpr.toString(indent + '\t')
					+ indent + "</ADDOPR>\n";
		}
}
