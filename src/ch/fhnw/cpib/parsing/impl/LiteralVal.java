package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ILiteralVal;

public class LiteralVal implements ILiteralVal {
    
    private final ILiteralVal.Type type;
    private final int value;
    
    public LiteralVal(final ILiteralVal.Type type, int value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public Type getType() {
       return type;
    }

    @Override
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString(final String indent) {
        return indent + 
                "<LiteralVal>\n"
                + indent + getType().toString() + '\t'
                + indent + type + '\t'
                + indent
                + "</LiteralVal>\n";
    }
    
}
