package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICmd1;

public class CmdCmd1 implements ICmd {

    private ICmd1 cmd1;
    public CmdCmd1(ICmd1 cmd1) {
        this.cmd1 = cmd1;
    }

}
