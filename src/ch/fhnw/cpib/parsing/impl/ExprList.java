package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICExprList;
import ch.fhnw.cpib.parsing.IExprList1;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.cpib.parsing.as.IAbsExprList;

public class ExprList implements ICExprList {

    private IToken lParent;
    private IExprList1 exprList1;
    private IToken rParent;

    public ExprList(IToken lParent, IExprList1 exprList1, IToken rParent) {
        this.lParent = lParent;
        this.exprList1 = exprList1;
        this.rParent = rParent;
    }

    @Override
    public IExprList toAbsSyn() {
        return exprList1.toAbsSyn();
    }

}
