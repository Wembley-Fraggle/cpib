package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;

public interface IExprList2 extends IConcSynNode {
    IExprList toAbsSyn();

		String toString(String indent);
}
