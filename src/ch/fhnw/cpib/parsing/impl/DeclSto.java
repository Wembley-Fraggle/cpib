package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IDecl;
import ch.fhnw.cpib.parsing.IStoDecl;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsDecl;
import ch.fhnw.cpib.parsing.as.impl.AbsStoDecl;

public class DeclSto implements IDecl {

    private IStoDecl stoDecl;
    public DeclSto(IStoDecl stoDecl) {
        this.stoDecl = stoDecl;
    }
		@Override
		public IAbsDecl toAbsSyn() {
			// TODO Auto-generated method stub
			return new AbsStoDecl();
		}

}
