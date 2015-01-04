package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;

public interface IExprList4 extends IConcSynNode {
    public IExprList toAbsSyn(IExprList left);
}
