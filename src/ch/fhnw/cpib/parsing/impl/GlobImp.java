package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IGlobImp;
import ch.fhnw.cpib.parsing.IGlobImp1;
import ch.fhnw.cpib.parsing.IGlobImp2;
import ch.fhnw.cpib.parsing.abs.IAbstSyn;

public class GlobImp implements IGlobImp {

	private IGlobImp1 globImp1;
	private IGlobImp2 globImp2;
	private IToken ident;

	public GlobImp(IGlobImp1 globImp1, IGlobImp2 globImp2, IToken ident) {
		this.globImp1 = globImp1;
		this.globImp2 = globImp2;
		this.ident = ident;
	}

	@Override
	public String toString(String indent) {
		return indent + "<GlobImp>\n" + globImp1.toString(indent + '\t')
				+ globImp2.toString(indent + '\t') + ident.toString(indent + '\t')
				+ indent + "<GlobImp/>\n";
	}

	@Override
	public IAbstSyn.IGlobImp toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.GlobImp(globImp1.toAbsSyn(),globImp2.toAbsSyn(),ident);
	}
}
