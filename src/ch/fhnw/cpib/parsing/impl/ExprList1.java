package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList1;
import ch.fhnw.cpib.parsing.IExprList2;

public class ExprList1 implements IExprList1 {

    private IExprList2 exprList2;
    public ExprList1(IExprList2 exprList2) {
        this.exprList2 = exprList2;
    }

}
