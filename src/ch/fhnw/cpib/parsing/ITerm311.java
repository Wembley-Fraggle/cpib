package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface ITerm311 extends IConcSynNode {
    IExpr toAbsSyn(IExpr expr);

		String toString(String indent);
}
