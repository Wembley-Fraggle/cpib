package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;

public interface IStoDecl extends IConcSynNode {

	IStoreDecl toAbsSyn();

	String toString(String indent);

}
