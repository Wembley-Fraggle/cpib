package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsCpsCmd;

public class CpsCmd1Eps implements ICpsCmd1 {
    public IAbsCpsCmd toAbsSyn(IAbsCpsCmd e) {
        return e;
    }
}
