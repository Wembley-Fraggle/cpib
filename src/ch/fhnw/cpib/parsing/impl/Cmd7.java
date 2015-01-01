package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd7;
import ch.fhnw.cpib.parsing.IExpr;

public class Cmd7 implements ICmd7{
    IExpr expr;
    public Cmd7(IExpr expr) {
        this.expr = expr;
    }
}
