package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl4;
import ch.fhnw.cpib.parsing.IPostcondition;

public class FunDecl4 implements IFunDecl4 {

    private IPostcondition postcondition;

    public FunDecl4(IPostcondition postcondition) {
        this.postcondition = postcondition;
    }

}
