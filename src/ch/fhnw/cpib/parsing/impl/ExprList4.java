package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.IExprList4;

public class ExprList4 implements IExprList4 {

    private IToken comma;
    private IExpr expr;
    
    public ExprList4(IToken comma, IExpr expr) {
        this.comma = comma;
        this.expr = expr;
    }

}