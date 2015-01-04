package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IExprList4;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class ExprList4 implements IExprList4 {

    private IToken comma;
    private IConcExpr expr;
    
    public ExprList4(IToken comma, IConcExpr expr) {
        this.comma = comma;
        this.expr = expr;
    }
    
    public IAbsExpr toAbsSyn() {
        return expr.toAbsSyn();
    }

}
