package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public interface IGlobImps extends IConcSynNode {

	IGlobImp toAbsSyn();

	String toString(String indent);

}
