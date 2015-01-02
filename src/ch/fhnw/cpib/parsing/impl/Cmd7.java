package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd7;
import ch.fhnw.cpib.parsing.IExpr;

public class Cmd7 implements ICmd7{
    IToken assertToken;
    IExpr expr;
    public Cmd7(IToken assertToken, IExpr expr) {
        this.assertToken = assertToken;
        this.expr = expr;
    }
}
