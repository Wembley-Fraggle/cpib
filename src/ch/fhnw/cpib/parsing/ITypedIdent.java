package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;

public interface ITypedIdent extends IConcSynNode {

	String toString(String indent);

	IAtomtype getAtomtype();
	
	IToken getIdent();

}
