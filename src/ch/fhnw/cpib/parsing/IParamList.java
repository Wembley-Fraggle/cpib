package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn;

//TODO Auto-generated stub
public interface IParamList extends IConcSynNode {

	IAbstSyn.IParam toAbsSyn();

	String toString(String indent);

}