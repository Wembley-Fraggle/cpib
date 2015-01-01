package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd;
import ch.fhnw.cpib.parsing.ICmd3;

public class CmdWhile implements ICmd {

    private ICmd3 cmd3;

    public CmdWhile(ICmd3 cmd3) {
        this.cmd3 = cmd3;
    }

}
