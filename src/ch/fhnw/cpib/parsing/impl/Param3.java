package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IParam3;

public class Param3 implements IParam3 {

    private IChangemode changemode;
    
    public Param3(IChangemode changemode) {
        this.changemode = changemode;
    }

}
