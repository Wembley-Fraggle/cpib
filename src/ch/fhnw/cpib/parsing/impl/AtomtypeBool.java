package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAtomtype;

public class AtomtypeBool implements IAtomtype {

	IToken bool;

	public AtomtypeBool(IToken bool) {
		this.bool = bool;
	}

	@Override
	public IToken toAbsSyn() {
		return bool;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Atomtype>" + bool.getValue() + "</Atomtype>\n";
	}
}
