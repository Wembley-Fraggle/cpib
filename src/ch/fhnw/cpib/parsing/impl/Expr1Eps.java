package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr1;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class Expr1Eps implements IExpr1 {
    public IAbsExpr toAbsSyn(IAbsExpr expr) {
        return expr;
    }
}
