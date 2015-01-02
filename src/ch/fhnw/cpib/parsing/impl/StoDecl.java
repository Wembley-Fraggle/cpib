package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IStoDecl;
import ch.fhnw.cpib.parsing.IStoDecl1;
import ch.fhnw.cpib.parsing.ITypedIdent;

public class StoDecl implements IStoDecl{
    private IStoDecl1 stoDecl1;
    private ITypedIdent typedIdent;
    
    public StoDecl(IStoDecl1 stoDecl1, ITypedIdent typedIdent) {
        this.stoDecl1 = stoDecl1;
        this.typedIdent = typedIdent;
    }

		@Override
		public IStoDecl toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}
}
