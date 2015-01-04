package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IExprList2;
import ch.fhnw.cpib.parsing.IExprList3;
import ch.fhnw.cpib.parsing.as.IAbsExprList;
import ch.fhnw.cpib.parsing.as.impl.AbsExprList;

public class ExprList2 implements IExprList2 {

    private IConcExpr expr;
    private IExprList3 exprList3;
    public ExprList2(IConcExpr expr, IExprList3 exprList3) {
        this.expr = expr;
        this.exprList3 = exprList3;
    }
    
    public IAbsExprList toAbsSyn() {
        return exprList3.toAbsSyn(expr.toAbsSyn());
    }

}
