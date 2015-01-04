package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

/**
 * 
 * [postcondition]
 */
public interface IFunDecl4 extends IConcSynNode {

	IDbcCmd toAbsSyn();

	String toString(String indent);

}
