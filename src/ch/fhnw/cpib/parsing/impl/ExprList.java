package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IExprList;
import ch.fhnw.cpib.parsing.IExprList1;

public class ExprList implements IExprList {

    private IToken lParent;
    private IExprList1 exprList1;
    private IToken rParent;

    public ExprList(IToken lParent, IExprList1 exprList1, IToken rParent) {
        this.lParent = lParent;
        this.exprList1 = exprList1;
        this.rParent = rParent;
    }

}
