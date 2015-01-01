package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICmd6;

public class CmdDebougOut implements ICmd {

    private ICmd6 cmd6;

    public CmdDebougOut(ICmd6 cmd6) {
        this.cmd6 = cmd6;
    }

}
