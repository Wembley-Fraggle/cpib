package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICParam;
import ch.fhnw.cpib.parsing.IParam1;
import ch.fhnw.cpib.parsing.IParam2;
import ch.fhnw.cpib.parsing.IParam3;
import ch.fhnw.cpib.parsing.ITypedIdent;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;
import ch.fhnw.cpib.parsing.abs.impl.StoreDecl;

public class Param implements ICParam {

	private IParam1 param1;
	private IParam2 param2;
	private IParam3 param3;
	private ITypedIdent typedIdent;

	public Param(IParam1 param1, IParam2 param2, IParam3 param3,
			ITypedIdent typedIdent) {
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.typedIdent = typedIdent;
	}

	@Override
	public String toString(String indent) {
		return indent + "<Param>\n" + param1.toString(indent + '\t')
				+ param2.toString(indent + '\t') + param3.toString(indent + '\t')
				+ typedIdent.toString(indent + '\t') + indent + "</Param>\n";
	}

	@Override
	public IParam toAbsSyn() {
		IStoreDecl stoDecl = new StoreDecl(param3.toAbsSyn(),
				typedIdent.getIdent(), typedIdent.getAtomtype().toAbsSyn().getType());
		return new ch.fhnw.cpib.parsing.abs.impl.Param(param1.toAbsSyn(),
				param2.toAbsSyn(), param3.toAbsSyn(), stoDecl);
	}

}
