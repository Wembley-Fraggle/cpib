package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFactor21;
import ch.fhnw.cpib.parsing.IFactor211;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;

public class Factor21 implements IFactor21 {

    private IFactor211 factor211;

    public Factor21(IFactor211 factor211) {
        this.factor211 = factor211;
    }

		@Override
		public IAbsExpr toAbsSyn(IToken ident) {
			return factor211.toAbsSyn();
		}

}
