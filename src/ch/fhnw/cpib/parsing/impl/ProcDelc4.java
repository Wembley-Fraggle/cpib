package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IPostcondition;
import ch.fhnw.cpib.parsing.IProcDecl4;

public class ProcDelc4 implements IProcDecl4 {

    private IPostcondition postcondition;

    public ProcDelc4(IPostcondition postcondition) {
        this.postcondition = postcondition;
    }

}
