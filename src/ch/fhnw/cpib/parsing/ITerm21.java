package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface ITerm21 extends IConcSynNode {
    public IExpr toAbsSyn(IExpr expr);
}
