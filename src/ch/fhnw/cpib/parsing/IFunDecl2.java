package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn;


/**
 * 
 * [LOCAL cpsStoDecl]
 */
public interface IFunDecl2 extends IConcSynNode {

	IAbstSyn.ICpsDecl toAbsSyn();

	String toString(String indent);

}
