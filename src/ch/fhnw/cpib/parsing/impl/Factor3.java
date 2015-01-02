package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFactor;
import ch.fhnw.cpib.parsing.IFactor3;
import ch.fhnw.cpib.parsing.IMonadicOpr;

public class Factor3 implements IFactor3 {

    private IMonadicOpr monadicOpr;
    private IFactor factor;
    
    public Factor3(IMonadicOpr monadicOpr, IFactor factor) {
        this.monadicOpr = monadicOpr;
        this.factor = factor;
    }

}
