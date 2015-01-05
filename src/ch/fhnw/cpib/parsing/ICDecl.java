package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

public interface ICDecl extends IConcSynNode {

	String toString(String indent);

	IDecl toAbsSyn();

}
