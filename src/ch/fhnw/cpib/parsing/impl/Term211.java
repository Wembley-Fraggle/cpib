package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IAddopr;
import ch.fhnw.cpib.parsing.ITerm211;
import ch.fhnw.cpib.parsing.ITerm3;

public class Term211 implements ITerm211 {

    private IAddopr addopr;
    private ITerm3 term3;
    
    public Term211(IAddopr addopr, ITerm3 term3) {
        this.addopr = addopr;
        this.term3 = term3;
    }

}
