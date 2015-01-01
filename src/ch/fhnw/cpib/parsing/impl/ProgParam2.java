package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IProgParam2;

public class ProgParam2 implements IProgParam2 {

    private IChangemode changemode;
    public ProgParam2(IChangemode changemode) {
        this.changemode = changemode;
    }

}
