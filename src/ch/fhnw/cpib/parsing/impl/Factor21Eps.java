package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFactor21;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprStore;

public class Factor21Eps implements IFactor21 {

	@Override
	public IExpr toAbsSyn(IToken ident) {
	    return new ExprStore(ident, false);
	}

	@Override
	public String toString(String indent) {
		return indent + "<Factor21Eps/>\n";
	}

}
