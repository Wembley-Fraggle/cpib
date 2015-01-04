package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IExprList4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.cpib.parsing.abs.impl.ExprList;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class ExprList4 implements IExprList4 {

    private IToken comma;
    private IConcExpr expr;
    
    public ExprList4(IToken comma, IConcExpr expr) {
        this.comma = comma;
        this.expr = expr;
    }

    @Override
    public IExprList toAbsSyn(IExprList list) {
       return new ExprList(expr.toAbsSyn(),list);
    }
    
}
