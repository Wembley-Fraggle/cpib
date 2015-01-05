package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface ITerm31 extends IConcSynNode {
    IExpr toAbsSyn(IExpr left);

		String toString(String indent);
}
