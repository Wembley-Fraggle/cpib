package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAddopr;
import ch.fhnw.cpib.parsing.IMonadicOpr;

public class MonadicOprAdd implements IMonadicOpr {

	private IAddopr addopr;

	public MonadicOprAdd(IAddopr addopr) {
		this.addopr = addopr;
	}

	public IToken toAbsSyn() {
		return addopr.toAbsSyn();
	}

	@Override
	public String toString(String indent) {
		return indent + "<MONADICOPR>\n" + addopr.toString(indent + '\t') + indent
				+ "</MONADICOPR>\n";
	}

}
