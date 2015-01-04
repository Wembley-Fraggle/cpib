package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IAtomtype;
import ch.fhnw.cpib.parsing.ITypedIdent;

public class TypedIdent implements ITypedIdent {

    private IToken ident;
    private IToken colon;
    private IAtomtype atomtype;

    public TypedIdent(IToken ident, IToken colon, IAtomtype atomtype) {
        this.ident = ident;
        this.colon = colon;
        this.atomtype = atomtype;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
