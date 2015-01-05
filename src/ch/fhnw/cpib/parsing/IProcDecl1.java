package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public interface IProcDecl1 extends IConcSynNode {

	String toString(String indent);

	IGlobImp toAbsSyn();

}
