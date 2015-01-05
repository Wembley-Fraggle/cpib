package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public interface IProgram3 extends IConcSynNode {

	String toString(String indent);

	IDbcCmd toAbsSyn();

}
