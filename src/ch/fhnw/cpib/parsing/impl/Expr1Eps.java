package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public class Expr1Eps implements IExpr1 {

    @Override
    public IExpr toAbsSyn(IExpr e) {
        return e;
    }
}
