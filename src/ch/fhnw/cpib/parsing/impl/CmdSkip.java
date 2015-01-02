package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.as.impl.AbsSkipCmd;
import ch.fhnw.cpib.parsing.as.impl.IAbsSkipCmd;

public class CmdSkip implements ICmd {

    private IToken skip;

    public CmdSkip(IToken skip) {
        this.skip = skip;
    }
    
    public IAbsSkipCmd toAbsSyn() {
        return new AbsSkipCmd();
    }

}
