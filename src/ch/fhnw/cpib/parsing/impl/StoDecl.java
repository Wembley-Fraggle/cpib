package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IStoDecl;
import ch.fhnw.cpib.parsing.IStoDecl1;
import ch.fhnw.cpib.parsing.ITypedIdent;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;
import ch.fhnw.cpib.parsing.abs.impl.StoreDecl;

public class StoDecl implements IStoDecl {
	private IStoDecl1 stoDecl1;
	private ITypedIdent typedIdent;

	public StoDecl(IStoDecl1 stoDecl1, ITypedIdent typedIdent) {
		this.stoDecl1 = stoDecl1;
		this.typedIdent = typedIdent;
	}

	@Override
	public IStoreDecl toAbsSyn() {
		return new StoreDecl(stoDecl1.toAbsSyn(), typedIdent.getIdent(), typedIdent
				.getAtomtype().getType());
	}

	@Override
	public String toString(final String indent) {
		return indent + "<StoDecl>\n" + stoDecl1.toString(indent + '\t')
				+ typedIdent.toString(indent + '\t') + indent + "</StoDecl>\n";
	}

}
