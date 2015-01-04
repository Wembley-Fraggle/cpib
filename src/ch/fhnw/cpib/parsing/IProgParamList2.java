package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;


public interface IProgParamList2 extends IConcSynNode {

	String toString(String indent);

    ICpsDecl toAbsSyn();

}
