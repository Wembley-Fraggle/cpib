package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IExprList2;
import ch.fhnw.cpib.parsing.IExprList3;

public class ExprList2 implements IExprList2 {

    private IExpr expr;
    private IExprList3 exprList3;
    public ExprList2(IExpr expr, IExprList3 exprList3) {
        this.expr = expr;
        this.exprList3 = exprList3;
    }

}
