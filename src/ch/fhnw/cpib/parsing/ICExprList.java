package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;

public interface ICExprList extends IConcSynNode {

    IExprList toAbsSyn();

		String toString(String indent);

}
