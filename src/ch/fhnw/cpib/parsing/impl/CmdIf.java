package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICmd2;

public class CmdIf implements ICmd {
    private ICmd2 cmd2;

    public CmdIf(ICmd2 cmd2) {
        this.cmd2 = cmd2;
    }
}
