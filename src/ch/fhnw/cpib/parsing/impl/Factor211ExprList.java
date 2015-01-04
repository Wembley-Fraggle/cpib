package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICExprList;
import ch.fhnw.cpib.parsing.IFactor211;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprCall;

public class Factor211ExprList implements IFactor211 {

    private ICExprList exprList;
    public Factor211ExprList(ICExprList exprList) {
        this.exprList = exprList;
    }
    @Override
    public IExpr toAbsSyn(IToken ident) {
        return new ExprCall(ident, exprList.toAbsSyn(), null);
    }
    
}
