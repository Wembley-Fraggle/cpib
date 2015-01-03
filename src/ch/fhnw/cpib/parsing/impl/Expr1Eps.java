package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr1;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class Expr1Eps implements IExpr1 {

    @Override
    public IAbsExpr toAbsSyn(IAbsExpr e) {
        return e;
    }
}
