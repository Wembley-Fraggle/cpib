package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IFunDecl3;
import ch.fhnw.cpib.parsing.IPrecondition;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public class FunDecl3 implements IFunDecl3 {

    private IPrecondition precondition;

    public FunDecl3(IPrecondition precondition) {
        this.precondition = precondition;
    }

		@Override
		public IDbcCmd toAbsSyn() {
			return precondition.toAbsSyn();
		}

		@Override
		public String toString(String indent) {
			return "<Precondition>" + precondition.toString(indent) + "</Precondition>\n";
		}

}
