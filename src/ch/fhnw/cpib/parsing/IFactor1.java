package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface IFactor1 extends IConcSynNode {
	String toString(String indent);

	IExpr toAbsSyn();
}
