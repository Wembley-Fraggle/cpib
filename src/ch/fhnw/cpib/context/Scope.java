package ch.fhnw.cpib.context;

import ch.fhnw.cpib.lexing.ITerminal;

public final class Scope {
    private final StoreTable storeTable;
    
    public Scope() {
        this(new StoreTable());
    }
    
    public Scope(final StoreTable storeTable) {
        this.storeTable = storeTable;
    }
    
    public StoreTable getStoreTable() {
        return storeTable;
    }
    
    public ITerminal getType(final String ident) {
        return storeTable.getType(ident);
    }
    
    public boolean addStore(final StoreTable stores) {
        for (Store symbol : stores.getTable().values()) {
            if (!storeTable.addStore(symbol)) {
                return false;
            }
        }
        return true;
    }
}
