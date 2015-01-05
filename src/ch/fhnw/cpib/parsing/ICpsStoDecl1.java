package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;

//TODO Auto-generated stub
public interface ICpsStoDecl1 extends IConcSynNode {

	String toString(String indent);

	ICpsDecl toAbsSyn(IStoreDecl absSyn);

}
