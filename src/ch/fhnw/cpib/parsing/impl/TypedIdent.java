package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAtomtype;
import ch.fhnw.cpib.parsing.ITypedIdent;

public class TypedIdent implements ITypedIdent {

	private IToken ident;
	@SuppressWarnings("unused")
	private IToken colon;
	private IAtomtype atomtype;

	public TypedIdent(IToken ident, IToken colon, IAtomtype atomtype) {
		this.ident = ident;
		this.colon = colon;
		this.atomtype = atomtype;
	}

	@Override
	public String toString(String indent) {
		return indent + "<TypedIdent>\n" + ident.toString(indent + '\t')
				+ atomtype.toString(indent + '\t') + indent + "</TypedIdent>\n";
	}

	@Override
	public IAtomtype getAtomtype() {
		return atomtype;
	}

	@Override
	public IToken getIdent() {
		return ident;
	}

}
