package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn;


public interface IGlobImp extends IConcSynNode {

	String toString(String indent);

	IAbstSyn.IGlobImp toAbsSyn();

}
