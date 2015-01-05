package ch.fhnw.cpib.context;

import ch.fhnw.cpib.parsing.ILiteralVal;

public final class Parameter {
    private final Modes flowMode;
    private final Modes mechMode;
    private final Modes changeMode;
    private final ILiteralVal.Type type;
    
    public Parameter(
            final Modes flowMode, 
            final Modes mechMode, 
            final Modes changeMode,
            final ILiteralVal.Type type) {
        this.flowMode = flowMode;
        this.mechMode = mechMode;
        this.changeMode = changeMode;
        this.type = type;
    }

    public Modes getFlowMode() {
        return flowMode;
    }

    public Modes getMechMode() {
        return mechMode;
    }

    public Modes getChangeMode() {
        return changeMode;
    }
    
    public ILiteralVal.Type getType() {
        return type;
    }
}
