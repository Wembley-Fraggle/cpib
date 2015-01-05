package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;

//TODO Auto-generated stub
public interface ITypedIdent extends IConcSynNode {

	String toString(String indent);

	IAtomtype getAtomtype();
	
	IToken getIdent();

}
