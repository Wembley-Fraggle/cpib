package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IFactor211;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprStore;

public class Factor211Init implements IFactor211 {

	private IToken init;

	public Factor211Init(IToken init) {
		this.init = init;
	}

	@Override
	public IExpr toAbsSyn(IToken ident) {
		return new ExprStore(ident, true);
	}

	@Override
	public String toString(String indent) {
		return indent + "<Factor211Init>\n" + init.toString(indent + '\t') + indent
				+ "</Factor211Init>\n";
	}

}
