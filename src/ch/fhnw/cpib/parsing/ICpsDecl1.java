package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

public interface ICpsDecl1 extends IConcSynNode {

	String toString(String indent);

	ICpsDecl toAbsSyn(IDecl absSyn);

}
