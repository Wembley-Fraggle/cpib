package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList3;
import ch.fhnw.cpib.parsing.IExprList4;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExprList;
import ch.fhnw.cpib.parsing.as.impl.AbsExprList;

public class ExprList3 implements IExprList3 {

    private IExprList4 exprList4;
    private IExprList3 exprList3;
    public ExprList3(IExprList4 exprList4, IExprList3 exprList3) {
        this.exprList4 = exprList4;
        this.exprList3 = exprList3;
    }
    
    @Override
    public IAbsExprList toAbsSyn(IAbsExpr expr) {
        IAbsExprList dyad = new AbsExprList(expr);
        return exprList3.toAbsSyn(dyad);
    }
    
    @Override
    public IAbsExprList toAbsSyn(IAbsExprList left) {
        IAbsExprList dyad = new AbsExprList(left, exprList4.toAbsSyn());
        return exprList3.toAbsSyn(dyad);
    }
    
    

}
