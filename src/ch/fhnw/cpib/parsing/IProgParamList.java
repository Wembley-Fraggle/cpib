package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;


public interface IProgParamList extends IConcSynNode {
    ICpsDecl toAbsSyn();
	String toString(String indent);
}
