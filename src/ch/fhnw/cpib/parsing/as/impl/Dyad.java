package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.as.IAbsSynNode;


public class Dyad {
    
    private ITerminal top;
    private IAbsSynNode left;
    private IAbsSynNode right;
    public Dyad(ITerminal top, IAbsSynNode left,IAbsSynNode right) {
        this.top = top;
        this.left = left;
        this.right = right;
    }
}
