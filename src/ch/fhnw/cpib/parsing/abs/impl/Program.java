package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.context.Scope;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IProgram;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

//TODO add progParams to code() 
public final class Program implements IProgram {
	private final IToken ident;
	private final IParam progParams;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	private final IDbcCmd dbcPreCmd;
	private final IDbcCmd dbcPostCmd;

	public Program(final IToken ident, final IParam progParams,
			final ICpsDecl cpsDecl, final IDbcCmd dbcPreCmd, final ICmd cmd,
			final IDbcCmd dbcPostCmd) {
		this.ident = ident;
		this.progParams = progParams;
		this.cpsDecl = cpsDecl;
		this.dbcPreCmd = dbcPreCmd;
		this.cmd = cmd;
		this.dbcPostCmd = dbcPostCmd;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<Program>\n" + ident.toString(indent + '\t')
				+ progParams.toString(indent + '\t') + cpsDecl.toString(indent + '\t')
				+ dbcPreCmd.toString(indent + '\t') + cmd.toString(indent + '\t')
				+ dbcPostCmd.toString(indent + '\t') + indent + "</Program>\n";
	}

	@Override
	public int getLine() {
		return ident.getStart().getCurrentLine();
	}

	@Override
	public void check() throws ContextError, HeapTooSmallError {
		cpsDecl.checkDeclaration();
		cpsDecl.check(-1);
		IMLCompiler.setScope(new Scope(IMLCompiler.getGlobalStoreTable().clone()));
		cmd.check(false);
	}

	@Override
	public int code(final int loc) throws CodeTooSmallError {
		int loc1 = dbcPreCmd.code(loc);
		int loc2 = cmd.code(loc1);
		int loc3 = dbcPostCmd.code(loc2);
		int loc4 = loc3 + 1;
		IMLCompiler.getVM().Stop(loc3);
		int loc5 = cpsDecl.code(loc4);
		for (Routine routine : IMLCompiler.getRoutineTable().getTable().values()) {
			routine.codeCalls();
		}
		return loc5;

	}
}
