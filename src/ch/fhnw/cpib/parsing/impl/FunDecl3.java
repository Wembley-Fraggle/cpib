package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl3;
import ch.fhnw.cpib.parsing.IPrecondition;

public class FunDecl3 implements IFunDecl3 {

    private IPrecondition precondition;

    public FunDecl3(IPrecondition precondition) {
        this.precondition = precondition;
    }

		@Override
		public IFunDecl3 toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}

}
