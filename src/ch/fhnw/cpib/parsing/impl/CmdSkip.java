package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.as.IAbsCmd;
import ch.fhnw.cpib.parsing.as.IAbsSkipCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsSkipCmd;

public class CmdSkip implements ICmd {

    private IToken skip;

    public CmdSkip(IToken skip) {
        this.skip = skip;
    }
    
    public IAbsCmd toAbsSyn() {
        return new AbsSkipCmd();
    }

}
