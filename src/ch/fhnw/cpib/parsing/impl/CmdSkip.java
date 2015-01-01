package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd;

public class CmdSkip implements ICmd {

    private IToken skip;

    public CmdSkip(IToken skip) {
        this.skip = skip;
    }

}
