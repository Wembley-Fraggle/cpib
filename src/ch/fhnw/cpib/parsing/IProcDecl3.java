package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public interface IProcDecl3 extends IConcSynNode {

	String toString(String indent);

	IDbcCmd toAbsSyn();

}
