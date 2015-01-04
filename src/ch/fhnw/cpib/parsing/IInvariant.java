package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public interface IInvariant extends IConcSynNode{

    IDbcCmd toAbsSyn();

	String toString(String indent);

}
