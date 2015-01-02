package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd6;
import ch.fhnw.cpib.parsing.IExpr;
import ch.fhnw.cpib.parsing.as.IAbsDebOutCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsDebOutCmd;

public class Cmd6 implements ICmd6 {
    IToken debugOut;
    IExpr expr;

    public Cmd6(IToken debugOut, IExpr expr) {
        this.debugOut = debugOut;
        this.expr = expr;
    }
    
    public IAbsDebOutCmd toAbsSyn() {
        return new AbsDebOutCmd(expr.toAbsSyn());
    }
}
