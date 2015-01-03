package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IDecl;
import ch.fhnw.cpib.parsing.IProcDecl;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsDecl;
import ch.fhnw.cpib.parsing.as.impl.AbsProcDecl;

public class DeclProc implements IDecl {

    private IProcDecl procDecl;
    public DeclProc(IProcDecl procDecl) {
        this.procDecl = procDecl;
    }
		@Override
		public IAbsDecl toAbsSyn() {
			// TODO Auto-generated method stub
			return new AbsProcDecl();
		}

}
