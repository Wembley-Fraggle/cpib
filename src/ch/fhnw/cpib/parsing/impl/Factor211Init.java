package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFactor211;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class Factor211Init implements IFactor211 {

    private IToken init;
    public Factor211Init(IToken init) {
        this.init = init;
    }
		@Override
		public IAbsExpr toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}

}
