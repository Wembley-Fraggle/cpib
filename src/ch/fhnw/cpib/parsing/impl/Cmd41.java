package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICmd41;
import ch.fhnw.cpib.parsing.IGlobInits;

public class Cmd41 implements ICmd41 {

    private IGlobInits globInits;
    
    public Cmd41(IGlobInits globInits) {
        this.globInits = globInits;
    }

}
