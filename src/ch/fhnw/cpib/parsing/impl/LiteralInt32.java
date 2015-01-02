package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ILiteral;


public class LiteralInt32 implements ILiteral {
    private IToken intVal;
    public LiteralInt32(IToken intVal) {
        this.intVal = intVal;
    }
}
