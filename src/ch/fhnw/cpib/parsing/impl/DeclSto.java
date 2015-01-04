package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IDecl;
import ch.fhnw.cpib.parsing.IStoDecl;

public class DeclSto implements IDecl {

    private IStoDecl stoDecl;
    public DeclSto(IStoDecl stoDecl) {
        this.stoDecl = stoDecl;
    }
		@Override
		public String toString() {
			return stoDecl.toString();
		}

}
