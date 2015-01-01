package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICmd5;

public class CmdDebugIn implements ICmd {

    private ICmd5 cmd5;
    public CmdDebugIn(ICmd5 cmd5) {
        this.cmd5 = cmd5;
    }

}
