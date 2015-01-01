package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IMechmode;
import ch.fhnw.cpib.parsing.IParam2;

public class Param2 implements IParam2 {

    private IMechmode mechmode;
    public Param2(IMechmode mechmode) {
        this.mechmode = mechmode;
    }

}
