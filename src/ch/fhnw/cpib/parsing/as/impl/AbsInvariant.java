package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsInvariant;

public class AbsInvariant implements IAbsInvariant{

    private IToken ident;
    private IAbsExpr expr;
    
    public AbsInvariant() {
        // expr = null => true
    }
    
    public AbsInvariant(IToken ident, IAbsExpr expr) {
        this.ident = ident;
        this.expr = expr;
    }

		@Override
		public String toString(String indent) {
			if (expr != null)
				return indent + "<Invariant>" + expr.toString(indent)
						+ "</Invariant>\n";
			else
				return indent + "<Invariant>true</Invariant>\n";
		}

}
