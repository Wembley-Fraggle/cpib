package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IDecl;
import ch.fhnw.cpib.parsing.IFunDecl;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsDecl;
import ch.fhnw.cpib.parsing.as.impl.AbsFunDecl;

public class DeclFun implements IDecl {

    private IFunDecl funDecl;
    public DeclFun(IFunDecl funDecl) {
        this.funDecl = funDecl;
    }
		@Override
		public IAbsDecl toAbsSyn() {
			// TODO Auto-generated method stub
			return new AbsFunDecl();
		}

}
