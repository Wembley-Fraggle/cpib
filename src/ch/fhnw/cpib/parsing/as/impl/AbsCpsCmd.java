package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsCmd;
import ch.fhnw.cpib.parsing.as.IAbsCpsCmd;

public class AbsCpsCmd implements IAbsCpsCmd {

    private IAbsCmd cmd;
    private IAbsCpsCmd absSyn;
    
    public AbsCpsCmd(IAbsCmd cmd) {
        this.cmd = cmd;
    }
    
    public AbsCpsCmd(IAbsCpsCmd cmd, IAbsCpsCmd absSyn) {
        this.cmd = cmd;
        this.absSyn = absSyn;
    }
}
