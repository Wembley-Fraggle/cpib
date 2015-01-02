package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICmd7;
import ch.fhnw.cpib.parsing.as.IAbsAssertCmd;

public class CmdAssert implements ICmd {

    private ICmd7 cmd7;

    public CmdAssert(ICmd7 cmd7) {
        this.cmd7 = cmd7;
    }
    
    public IAbsAssertCmd toAbsSyn() {
        return this.cmd7.toAbsSyn();
    }

}
