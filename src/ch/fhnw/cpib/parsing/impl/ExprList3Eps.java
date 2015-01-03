package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList3;
import ch.fhnw.cpib.parsing.as.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsExprList;
import ch.fhnw.cpib.parsing.as.impl.AbsExprList;

public class ExprList3Eps implements IExprList3 {
    
    public IAbsExprList toAbsSyn(IAbsExpr expr) {
        return new AbsExprList(expr) ;
    }
    
    public IAbsExprList toAbsSyn(IAbsExprList expr) {
        return expr;
    }
}
