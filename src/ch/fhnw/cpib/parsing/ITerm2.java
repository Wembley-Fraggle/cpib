package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface ITerm2 extends IConcSynNode {
    IExpr toAbsSyn();
}
