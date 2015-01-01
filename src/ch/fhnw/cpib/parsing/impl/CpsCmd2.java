package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICpsCmd2;

public class CpsCmd2 implements ICpsCmd2 {
    private IToken semi;
    private ICmd cmd;

    public CpsCmd2(IToken semi, ICmd cmd) {
        this.semi = semi;
        this.cmd = cmd;
    }

}