package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public class DbcCmd implements IDbcCmd {

	private final IToken ident;
	private final ICmd expr;

	public DbcCmd(IToken ident, ICmd cmd) {
		this.ident = ident;
		this.expr = cmd;
	}

	@Override
	public void check(boolean canInit) throws ContextError {
		// TODO Auto-generated method stub

	}

	@Override
	public int code(int loc) throws CodeTooSmallError {
		int loc1 = expr.code(loc);
		int loc2 = loc1 + 1;
		int loc3 = loc2 + 1;
		int loc4 = loc3 + 1;
		IMLCompiler.getVM().CondJump(loc1, loc3);
		IMLCompiler.getVM().UncondJump(loc2, loc4);
		IMLCompiler.getVM().Error(loc3, ident.getValue());
		return loc4;
	}

	@Override
	public String toString(String indent) {
	    return indent
	      + "<DbcCmd>\n"
	      + ident.toString(indent + '\t')
	      + expr.toString(indent + '\t')
          + indent
          + "</DbcCmd>\n";
	}

	@Override
	public int getLine() {
		return ident.getStart().getCurrentLine();
	}

}
