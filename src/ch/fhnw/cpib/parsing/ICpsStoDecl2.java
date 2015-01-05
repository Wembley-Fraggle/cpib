package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;

public interface ICpsStoDecl2 extends IConcSynNode {

	String toString(String indent);

	IStoreDecl toAbsSyn();

}
