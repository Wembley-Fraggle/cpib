package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsCpsCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsCpsCmd;

public class CpsCmd implements ICpsCmd{
    private ICmd cmd;
    private ICpsCmd1 cpsCmd1;
    
    public CpsCmd(ICmd cmd, ICpsCmd1 cpsCmd1) {
        this.cmd = cmd;
        this.cpsCmd1 = cpsCmd1;
    }

    @Override
    public IAbsCpsCmd toAbsSyn() {
        return cpsCmd1.toAbsSyn( new AbsCpsCmd(cmd.toAbsSyn()));
    }
}
