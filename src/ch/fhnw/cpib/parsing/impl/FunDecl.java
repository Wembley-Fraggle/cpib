package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.IFunDecl;
import ch.fhnw.cpib.parsing.IFunDecl1;
import ch.fhnw.cpib.parsing.IFunDecl2;
import ch.fhnw.cpib.parsing.IFunDecl3;
import ch.fhnw.cpib.parsing.IFunDecl4;
import ch.fhnw.cpib.parsing.IParamList;
import ch.fhnw.cpib.parsing.IStoDecl;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsDecl;
import ch.fhnw.cpib.parsing.as.impl.AbsFunDecl;

public class FunDecl implements IFunDecl {

	private IToken fun;
	private IToken ident;
	private IParamList paramList;
	private IToken returns;
	private IStoDecl stoDecl;
	private IFunDecl1 funDecl1;
	private IFunDecl2 funDecl2;
	private IFunDecl3 funDecl3;
	private IToken consume4;
	private ICpsCmd cpsCmd;
	private IFunDecl4 funDecl4;
	private IToken endFun;

	public FunDecl(IToken fun, IToken ident, IParamList paramList,
			IToken returns, IStoDecl stoDecl, IFunDecl1 funDecl1, IFunDecl2 funDecl2,
			IFunDecl3 funDecl3, IToken consume4, ICpsCmd cpsCmd, IFunDecl4 funDecl4,
			IToken endFun) {
		this.fun = fun;
		this.ident = ident;
		this.paramList = paramList;
		this.returns = returns;
		this.stoDecl = stoDecl;
		this.funDecl1 = funDecl1;
		this.funDecl2 = funDecl2;
		this.funDecl3 = funDecl3;
		this.consume4 = consume4;
		this.cpsCmd = cpsCmd;
		this.funDecl4 = funDecl4;
		this.endFun = endFun;
	}

	public IAbsDecl toAbsSyn() {
		return new AbsFunDecl(paramList.toAbsSyn(), stoDecl.toAbsSyn(), funDecl1.toAbsSyn(),
				funDecl2.toAbsSyn(), funDecl3.toAbsSyn(), cpsCmd.toAbsSyn(), funDecl4.toAbsSyn(null));
	}
}
