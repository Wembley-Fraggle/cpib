package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Procedure;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public final class ProcDecl implements IDecl {
	private final IToken ident;
	private final IParam param;
	private final IGlobImp globImp;
	private final ICpsDecl cpsDecl;
	private final IDbcCmd dbcPreCmd;
	private final ICmd cmd;
	private final IDbcCmd dbcPostCmd;

	public ProcDecl(final IToken ident, final IParam param,
			final IGlobImp globImp, final ICpsDecl cpsDecl, final IDbcCmd dbcPreCmd,
			final ICmd cmd, final IDbcCmd dbcPostCmd) {
		this.ident = ident;
		this.param = param;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.dbcPreCmd = dbcPreCmd;
		this.cmd = cmd;
		this.dbcPostCmd = dbcPostCmd;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<ProcDecl>\n" + ident.toString(indent + '\t')
				+ param.toString(indent + '\t') + globImp.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t') + cmd.toString(indent + '\t')
				+ indent + "</ProcDecl>\n";
	}

	@Override
	public int getLine() {
		return ident.getStart().getCurrentLine();
	}

	@Override
	public void checkDeclaration() throws ContextError {
		Procedure procedure = new Procedure(ident.getValue());
		IMLCompiler.setScope(procedure.getScope());

		if (!IMLCompiler.getRoutineTable().addRoutine(procedure)) {
			throw new ContextError("Ident already declared: " + ident.getValue(),
					ident.getStart().getCurrentLine());
		}

		param.check(procedure);
		IMLCompiler.setScope(null);
	}

	@Override
	public int check(final int locals) throws ContextError, HeapTooSmallError {
		if (locals >= 0) {
			throw new ContextError(
					"Function declarations are only allowed globally!", ident.getStart()
							.getCurrentLine());
		}

		Routine routine = IMLCompiler.getRoutineTable()
				.getRoutine(ident.getValue());
		IMLCompiler.setScope(routine.getScope());

		globImp.check(routine);

		int localsCount = param.calculateAddress(routine.getParamList().size(), 0);

		cpsDecl.check(localsCount);
		cmd.check(false);

		IMLCompiler.setScope(null);
		return -1;
	}

	@Override
	public int code(final int loc) throws CodeTooSmallError {
		int loc1 = loc;
		Routine routine = IMLCompiler.getRoutineTable().getRoutine(
	  	ident.getValue());

		IMLCompiler.setScope(routine.getScope());
		routine.setAddress(loc1);
		IMLCompiler.getVM().Enter(
	        	loc1++,
	        	routine.getInOutCopyCount() + cpsDecl.getCount(),0);
		loc1 = param.codeIn(
	        	loc1,routine.getParamList().size(), 0);
		loc1 = dbcPreCmd.code(loc1);
		loc1 = cmd.code(loc1);
		loc1 = dbcPostCmd.code(loc1);
		loc1 = param.codeOut(loc1,routine.getParamList().size(),0);
		IMLCompiler.getVM().Return(loc1++, 0);
		IMLCompiler.setScope(null);
		return loc1;

	}
}
