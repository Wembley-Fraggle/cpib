package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

/**
 * 
 * [precondition]
 */
public interface IFunDecl3 extends IConcSynNode {

	IDbcCmd toAbsSyn();

	String toString(String indent);

}
