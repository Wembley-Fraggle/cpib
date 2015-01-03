package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsProcCallCmd;

public class AbsProcCallCmd implements IAbsProcCallCmd{

    private IToken ident;
    private IAbsExprList absExprList;

    public AbsProcCallCmd(IToken ident, IAbsExprList absExprList) {
        this.ident = ident;
        this.absExprList = absExprList;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
