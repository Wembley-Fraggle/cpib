package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ITerm21;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Term21Eps implements ITerm21 {

    @Override
    public IExpr toAbsSyn(IExpr expr) {
        return expr;
    }

		@Override
		public String toString(String indent) {
			return indent + "<Term21Eps/>\n";
		}

}
