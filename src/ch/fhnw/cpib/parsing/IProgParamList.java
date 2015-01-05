package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;


public interface IProgParamList extends IConcSynNode {
	IParam toAbsSyn();
	String toString(String indent);
}
