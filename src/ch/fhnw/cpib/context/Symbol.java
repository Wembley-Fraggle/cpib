package ch.fhnw.cpib.context;

import ch.fhnw.cpib.lexing.ITerminal;

public abstract class Symbol {
    private String ident;
    private ITerminal type;
    
    public final String getIdent() {
        return ident;
    }
    
    public final ITerminal getType() {
        return type;
    }
    
    protected Symbol(final String ident, final ITerminal type) {
        this.ident = ident;
        this.type = type;
    }

}
