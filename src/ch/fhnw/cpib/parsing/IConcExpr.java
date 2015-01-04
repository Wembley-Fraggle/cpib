package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;


public interface IConcExpr extends IConcSynNode {
    public IExpr toAbsSyn();
}
