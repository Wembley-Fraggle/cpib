package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsDecl1;
import ch.fhnw.cpib.parsing.ICpsDecl2;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsDecl;

public class CpsDecl1 implements ICpsDecl1 {

    private ICpsDecl2 cpsDecl2;
    private ICpsDecl1 cpsDecl1;

    public CpsDecl1(ICpsDecl2 cpsDecl2, ICpsDecl1 cpsDecl1) {
        this.cpsDecl2 = cpsDecl2;
        this.cpsDecl1 = cpsDecl1;
    }

		@Override
		public IAbsDecl toAbsSyn(IAbsDecl iAbsDecl) {
			// TODO Auto-generated method stub
			return iAbsDecl;
		}


}
