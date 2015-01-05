package ch.fhnw.cpib.context;

import ch.fhnw.cpib.parsing.ILiteralVal;

public abstract class Symbol {
    private String ident;
    private ILiteralVal.Type type;
    
    public final String getIdent() {
        return ident;
    }
    
    public final ILiteralVal.Type getType() {
        return type;
    }
    
    protected Symbol(final String ident, final ILiteralVal.Type type) {
        this.ident = ident;
        this.type = type;
    }

}
