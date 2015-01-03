package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsDebOutCmd;

public class AbsDebOutCmd implements IAbsDebOutCmd {

    private IAbsExpr expr;

    public AbsDebOutCmd(IAbsExpr expr) {
        this.expr = expr;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
