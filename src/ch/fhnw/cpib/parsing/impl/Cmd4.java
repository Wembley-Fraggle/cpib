package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd4;
import ch.fhnw.cpib.parsing.ICExprList;
import ch.fhnw.cpib.parsing.as.IAbsProcCallCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsProcCallCmd;

public class Cmd4 implements ICmd4 {

    private IToken call;
    private IToken ident;
    private ICExprList exprList;
    
    public Cmd4(IToken call, IToken ident, ICExprList exprList) {
        this.call = call;
        this.ident = ident;
        this.exprList = exprList;
    }
    
    public IAbsProcCallCmd toAbsSyn() {
        return new AbsProcCallCmd(ident, exprList.toAbsSyn());
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
