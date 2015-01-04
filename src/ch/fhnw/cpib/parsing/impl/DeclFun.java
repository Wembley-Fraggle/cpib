package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IDecl;
import ch.fhnw.cpib.parsing.IFunDecl;

public class DeclFun implements IDecl {

    private IFunDecl funDecl;
    public DeclFun(IFunDecl funDecl) {
        this.funDecl = funDecl;
    }
		@Override
		public String toString() {
			return funDecl.toString();
		}

}
