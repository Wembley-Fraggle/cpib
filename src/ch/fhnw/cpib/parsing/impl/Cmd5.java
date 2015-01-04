package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd5;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.as.IAbsDebIntCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsDebIntCmd;

public class Cmd5 implements ICmd5 {
    private IToken debugIn;
    private IConcExpr expr;

    public Cmd5(IToken debugIn, IConcExpr expr) {
        this.debugIn = debugIn;
        this.expr = expr;
    }
    
    public IAbsDebIntCmd toAbsSyn() {
        return new AbsDebIntCmd(expr.toAbsSyn());
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
