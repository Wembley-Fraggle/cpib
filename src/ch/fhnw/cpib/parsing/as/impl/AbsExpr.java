package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class AbsExpr implements IAbsExpr{
    
    private ITerminal term;
    private IAbsExpr left;
    private IAbsExpr right;
    public AbsExpr(ITerminal term, IAbsExpr left, IAbsExpr right) {
        this.term = term;
        this.left = left;
        this.right = right;
    }
}
