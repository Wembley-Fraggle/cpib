package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParamList3;
import ch.fhnw.cpib.parsing.IProgParamList4;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsParam;

public class ProgParamList3 implements IProgParamList3 {

    private IProgParam progParam;
    private IProgParamList4 progParamList4;

    public ProgParamList3(IProgParam progParam, IProgParamList4 progParamList4) {
        this.progParam = progParam;
        this.progParamList4 = progParamList4;
    }

		@Override
		public IAbsParam toAbsSyn() {
			// TODO Auto-generated method stub
			return progParamList4.toAbsSyn();
		}

}
