package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface ILiteral extends IConcSynNode{
    public IExpr toAbsSyn();
}
