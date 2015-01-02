package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd1;
import ch.fhnw.cpib.parsing.IExpr;

public class Cmd1 implements ICmd1 {

    private IExpr expr;
    private IToken becomes;
    private IExpr expr2;
    public Cmd1(IExpr expr, IToken becomes, IExpr expr2) {
        this.expr = expr;
        this.becomes = becomes;
        this.expr2 = expr2;
    }

}
