package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParam;
import ch.fhnw.cpib.parsing.IParamList2;
import ch.fhnw.cpib.parsing.IParamList3;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsParam;

public class ParamList2 implements IParamList2 {

    private IParam param;
    private IParamList3 paramList3;
    public ParamList2(IParam param, IParamList3 paramList3) {
        this.param = param;
        this.paramList3 = paramList3;
    }
		@Override
		public IAbsParam toAbsSyn() {
			// TODO Auto-generated method stub
			return paramList3.toAbsSyn();
		}

}
