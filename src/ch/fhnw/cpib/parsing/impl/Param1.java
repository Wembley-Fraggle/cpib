package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IParam1;

public class Param1 implements IParam1 {

    private IFlowmode flowmode;
    public Param1(IFlowmode flowmode) {
        this.flowmode = flowmode;
    }

}