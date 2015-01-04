package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IBoolopr;

public class BooloprCor implements IBoolopr {

    private IToken boolOprCor;
    public BooloprCor(IToken boolOprCor) {
       this.boolOprCor = boolOprCor;
    }
    
    @Override
    public IToken toAbsSyn() {
        return boolOprCor;
    }

		@Override
		public String toString(String indent) {
			return indent + "<BOOLOPR>\n" + boolOprCor.toString(indent + '\t')
					+ indent + "</BOOLOPR>\n";
		}

}
