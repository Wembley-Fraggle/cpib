package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsDyad;
import ch.fhnw.cpib.parsing.as.IAbsSynNode;


public class AbsDyad implements IAbsDyad{
    
    private IToken top;
    private IAbsSynNode left;
    private IAbsSynNode right;
    public AbsDyad(IToken top, IAbsSynNode left,IAbsSynNode right) {
        this.top = top;
        this.left = left;
        this.right = right;
    }
}
