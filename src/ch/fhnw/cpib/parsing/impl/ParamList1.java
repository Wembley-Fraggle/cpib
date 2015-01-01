package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParamList1;
import ch.fhnw.cpib.parsing.IParamList2;

public class ParamList1 implements IParamList1 {

    private IParamList2 paramList2;
    public ParamList1(IParamList2 paramList2) {
        this.paramList2 = paramList2;
    }

}
