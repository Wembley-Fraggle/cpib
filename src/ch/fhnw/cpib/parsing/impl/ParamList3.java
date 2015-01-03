package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IParamList3;
import ch.fhnw.cpib.parsing.IParamList4;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsParam;

public class ParamList3 implements IParamList3 {

    private IParamList4 paramList4;
    private IParamList3 paramList3;
    
    public ParamList3(IParamList4 paramList4, IParamList3 paramList3) {
        this.paramList4 = paramList4;
        this.paramList3 = paramList3;
    }

		@Override
		public IAbsParam toAbsSyn() {
			// TODO Auto-generated method stub
			return paramList4.toAbsSyn();
		}

}
