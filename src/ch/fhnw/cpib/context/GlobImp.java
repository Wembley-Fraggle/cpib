package ch.fhnw.cpib.context;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IFlowmode;

public final class GlobImp {
    private final IFlowmode flowMode;
    private final IChangemode changeMode;
    private final String ident;
    
    public IFlowmode getFlowMode() {
        return flowMode;
    }

    public IChangemode getChangeMode() {
        return changeMode;
    }

    public String getIdent() {
        return ident;
    }

    public GlobImp(
            final IFlowmode flowMode,
            final IChangemode changeMode,
            final String ident) {
        this.flowMode = flowMode;
        this.changeMode = changeMode;
        this.ident = ident;
    } 
}
