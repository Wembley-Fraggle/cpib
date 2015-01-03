package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsAssertCmd;

public class AbsAssertCmd implements IAbsAssertCmd {

    private IAbsExpr expr;
    public AbsAssertCmd(IAbsExpr expr) {
        this.expr = expr;
    }
		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
