package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.as.IAbsDyad;
import ch.fhnw.cpib.parsing.as.IAbsExpr;
import ch.fhnw.cpib.parsing.as.IAbsSynNode;


public class AbsDyad implements IAbsDyad{
    
    private IToken top;
    private IAbsExpr left;
    private IAbsExpr right;
    public AbsDyad(IToken top, IAbsExpr left,IAbsExpr right) {
        this.top = top;
        this.left = left;
        this.right = right;
    }
}
