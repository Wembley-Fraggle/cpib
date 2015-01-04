package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;


public interface IExpr1 extends IConcSynNode {

    IExpr toAbsSyn(IExpr absSyn);

}
