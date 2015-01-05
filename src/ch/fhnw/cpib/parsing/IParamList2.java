package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public interface IParamList2 extends IConcSynNode {

	IParam toAbsSyn();

	String toString(String indent);

}
