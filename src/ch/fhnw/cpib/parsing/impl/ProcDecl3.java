package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IPrecondition;
import ch.fhnw.cpib.parsing.IProcDecl3;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public class ProcDecl3 implements IProcDecl3 {

	private IPrecondition precondition;

	public ProcDecl3(IPrecondition precondition) {
		this.precondition = precondition;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Precondition>" + precondition.toString(indent)
				+ "</Precondition>\n";
	}

	@Override
	public IDbcCmd toAbsSyn() {
		return precondition.toAbsSyn();
	}

}
