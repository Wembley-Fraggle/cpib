package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICpsDecl;
import ch.fhnw.cpib.parsing.ICpsDecl1;
import ch.fhnw.cpib.parsing.IDecl;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsDecl;

public class CpsDecl implements ICpsDecl{
    private IDecl decl;
    private ICpsDecl1 cpsDecl1;
    
    public CpsDecl(IDecl decl, ICpsDecl1 cpsDecl1) {
        this.decl = decl;
        this.cpsDecl1 = cpsDecl1;
    }

		@Override
		public IAbsDecl toAbsSyn() {
			// TODO Auto-generated method stub
			return cpsDecl1.toAbsSyn(decl.toAbsSyn());
		}
}
