package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn;

/**
 * [GLOBAL globImps]
 *
 */
public interface IFunDecl1 extends IConcSynNode {

	IAbstSyn.IGlobImp toAbsSyn();

	String toString(String indent);

}
