package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IGlobImp2;

public class GlobImp2 implements IGlobImp2 {

    private IChangemode changemode;
    public GlobImp2(IChangemode changemode) {
        this.changemode = changemode;
    }
}
