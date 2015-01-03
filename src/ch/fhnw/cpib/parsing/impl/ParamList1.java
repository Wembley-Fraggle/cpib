package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParamList1;
import ch.fhnw.cpib.parsing.IParamList2;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsParam;

public class ParamList1 implements IParamList1 {

    private IParamList2 paramList2;
    public ParamList1(IParamList2 paramList2) {
        this.paramList2 = paramList2;
    }
		@Override
		public IAbsParam toAbsSyn() {
			// TODO Auto-generated method stub
			return paramList2.toAbsSyn();
		}

}
