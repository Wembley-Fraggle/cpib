package ch.fhnw.cpib.context;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class Store extends Symbol {
    private boolean writeable;
    private boolean initialized;
    private boolean isConst;
    private int address;
    private boolean relative = false;
    private boolean reference = false;
    
    public Store(
            final String ident, 
            final ILiteralVal.Type type, 
            final boolean isConst) {
        super(ident, type);
        this.writeable = true;
        this.initialized = false;
        this.isConst = isConst;
    }
    
    public boolean isConst() {
        return isConst;
    }

    public boolean isWriteable() {
        return writeable;
    }

    public boolean isInitialized() {
        return initialized;
    }
    
    public void initialize() { 
        initialized = true;
        if (isConst) {
            writeable = false;
        }
    }
    
    public int getAddress() {
        return address;
    }

    public void setAddress(final int address) {
        this.address = address;
    }

    public void setRelative(final boolean relative) {
        this.relative = relative;
    }
    
    public void setReference(final boolean reference) {
        this.reference = reference;
    }

    public int codeLoad(final int loc) throws CodeTooSmallError {
        int loc1 = codeRef(loc);
        
        IMLCompiler.getVM().Deref(loc1++);
        
        return loc1;
    }
    
    public int codeRef(final int loc) throws CodeTooSmallError {
        int loc1 = loc;
        if (relative) {
            IMLCompiler.getVM().LoadRel(loc1++, address);
        } else {
            IMLCompiler.getVM().IntLoad(loc1++, address);
        }
        
        if (reference) {
            IMLCompiler.getVM().Deref(loc1++);
        }
        
        return loc1;
    }
    
    public Store clone() {
        Store store = new Store(
                this.getIdent(),
                this.getType(),
                this.isConst);
        store.address = this.address;
        store.initialized = this.initialized;
        store.writeable = this.writeable;
        return store;
    }
}
