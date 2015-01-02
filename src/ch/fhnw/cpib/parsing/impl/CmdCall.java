package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICmd4;
import ch.fhnw.cpib.parsing.as.IAbsAssertCmd;
import ch.fhnw.cpib.parsing.as.IAbsProcCallCmd;

public class CmdCall implements ICmd {
    private ICmd4 cmd4;

    public CmdCall(ICmd4 cmd4) {
        this.cmd4 = cmd4;
    }
    
    public IAbsProcCallCmd toAbsSyn() {
        return cmd4.toAbsSyn();
    }
}
