package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IProgParam;
import ch.fhnw.cpib.parsing.IProgParam1;
import ch.fhnw.cpib.parsing.IProgParam2;
import ch.fhnw.cpib.parsing.ITypedIdent;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;
import ch.fhnw.cpib.parsing.abs.impl.StoreDecl;

public class ProgParam implements IProgParam {

	private IProgParam1 progParam1;
	private IProgParam2 progParam2;
	private ITypedIdent typedIdent;

	public ProgParam(IProgParam1 progParam1, IProgParam2 progParam2,
			ITypedIdent typedIdent) {
		this.progParam1 = progParam1;
		this.progParam2 = progParam2;
		this.typedIdent = typedIdent;
	}

	@Override
	public String toString(String indent) {
		return indent + "<ProgParam>\n" + progParam1.toString(indent + '\t')
				+ progParam2.toString(indent + '\t')
				+ typedIdent.toString(indent + '\t') + indent + "</ProgParam>\n";
	}

	@Override
	public IParam toAbsSyn(IParam iParam) {
		IStoreDecl stoDecl = new StoreDecl(progParam2.toAbsSyn(),
				typedIdent.getIdent(), typedIdent.getAtomtype().toAbsSyn().getType());
		return new ch.fhnw.cpib.parsing.abs.impl.ProgParam(progParam1.toAbsSyn(),
				progParam2.toAbsSyn(), stoDecl, iParam);
	}
}
