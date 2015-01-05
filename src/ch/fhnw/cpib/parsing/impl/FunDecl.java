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
import ch.fhnw.cpib.parsing.abs.IAbstSyn;

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

	public IAbstSyn.IDecl toAbsSyn() {
		return new ch.fhnw.cpib.parsing.abs.impl.FunDecl(
				ident, 
				paramList.toAbsSyn(), 
				stoDecl.toAbsSyn(), 
				funDecl1.toAbsSyn(),
				funDecl2.toAbsSyn(), 
				funDecl3.toAbsSyn(), 
				cpsCmd.toAbsSyn(), 
				funDecl4.toAbsSyn());
	}
	
	@Override
	public String toString(String indent) {
		return indent
				+ "<FunDecl>\n"
				+ ident.toString(indent + '\t')
				+ paramList.toString(indent + '\t')
				+ stoDecl.toString(indent + '\t')
				+ funDecl1.toString(indent + '\t')
				+ funDecl2.toString(indent + '\t')
				+ funDecl3.toString(indent + '\t')
				+ cpsCmd.toString(indent + '\t')
				+ funDecl4.toString(indent + '\t')
				+ indent
				+ "</FunDecl>\n";
	}
}
