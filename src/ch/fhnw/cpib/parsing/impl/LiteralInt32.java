package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ILiteral;

public class LiteralInt32 implements ILiteral {
    private int value;
    public LiteralInt32(int value) {
        this.value = value;
    }
}