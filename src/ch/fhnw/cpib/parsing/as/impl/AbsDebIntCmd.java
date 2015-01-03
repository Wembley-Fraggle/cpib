package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsDebIntCmd;

public class AbsDebIntCmd implements IAbsDebIntCmd{

    private IAbsExpr expr;
    
    public AbsDebIntCmd(IAbsExpr expr) {
        this.expr = expr;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
