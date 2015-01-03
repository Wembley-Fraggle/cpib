package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr1;
import ch.fhnw.cpib.parsing.IExpr2;
import ch.fhnw.cpib.parsing.as.IAbsExpr;
import ch.fhnw.cpib.parsing.as.impl.AbsExpr;

public class Expr1 implements IExpr1 {

    private IExpr2 expr2;
    private IExpr1 expr1;

    public Expr1(IExpr2 expr2, IExpr1 expr1) {
        this.expr2 = expr2;
        this.expr1 = expr1;
    }

    @Override
    public IAbsExpr toAbsSyn(IAbsExpr expr) {
        return expr1.toAbsSyn(expr2.toAbsSyn(expr));
    }

}
