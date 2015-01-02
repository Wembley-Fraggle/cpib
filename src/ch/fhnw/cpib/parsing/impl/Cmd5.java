package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd5;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.as.IAbsDebIntCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsDebIntCmd;

public class Cmd5 implements ICmd5 {
    private IToken debugIn;
    private IExpr expr;

    public Cmd5(IToken debugIn, IExpr expr) {
        this.debugIn = debugIn;
        this.expr = expr;
    }
    
    public IAbsDebIntCmd toAbsSyn() {
        return new AbsDebIntCmd(expr.toAbsSyn());
    }

}
