package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Function;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.context.Store;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public final class FunDecl implements IDecl {
	private final IToken ident;
	private final IParam param;
	private final IStoreDecl returnDecl;
	private final IGlobImp globImp;
	private final IDbcCmd dbcPreCmd;
	private final ICpsDecl cpsDecl;
	private final IDbcCmd dbcPostCmd;
	private final ICmd cmd;

	public FunDecl(final IToken ident, final IParam param,
			final IStoreDecl returnDecl, final IGlobImp globImp, final ICpsDecl cpsDecl,
			final IDbcCmd dbcPreCmd, final ICmd cmd, final IDbcCmd dbcPostCmd) {
		this.ident = ident;
		this.param = param;
		this.returnDecl = returnDecl;
		this.globImp = globImp;
		this.dbcPreCmd = dbcPreCmd;
		this.cpsDecl = cpsDecl;
		this.dbcPostCmd = dbcPostCmd;
		this.cmd = cmd;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<FunDecl>\n" + ident.toString(indent + '\t')
				+ param.toString(indent + '\t') + returnDecl.toString(indent + '\t')
				+ globImp.toString(indent + '\t') + cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t') + indent + "</FunDecl>\n";
	}

	@Override
	public int getLine() {
		return ident.getStart().getCurrentLine();
	}

	@Override
	public void checkDeclaration() throws ContextError {
		Function function = new Function(ident.getValue(), returnDecl.getType());
		IMLCompiler.setScope(function.getScope());
		if (!IMLCompiler.getRoutineTable().addRoutine(function)) {
			throw new ContextError("Routine already declared: " + ident.getValue(),
					ident.getStart().getCurrentLine());
		}

		param.check(function);
		IMLCompiler.setScope(null);
	}

	@Override
	public int check(final int locals) throws ContextError, HeapTooSmallError {
		if (locals >= 0) {
			throw new ContextError(
					"Function declarations are only allowed globally!", ident.getStart()
							.getCurrentLine());
		}

		Routine routine = IMLCompiler.getRoutineTable().getRoutine(
				ident.getValue().toString());
		IMLCompiler.setScope(routine.getScope());

		Store retStore = returnDecl.check();
		retStore.setAddress(-routine.getParamList().size() - 1);
		retStore.setReference(false);
		retStore.setRelative(true);

		globImp.check(routine);

		int localsCount = param.calculateAddress(routine.getParamList().size(), 0);

		cpsDecl.check(localsCount);
		cmd.check(false);

		if (!routine.getScope().getStoreTable().getStore(returnDecl.getIdent())
				.isInitialized()) {
			throw new ContextError("Return value never initialized! Function: "
					+ ident.getValue(), ident.getStart().getCurrentLine());
		}

		IMLCompiler.setScope(null);
		return -1;
	}

	@Override
	public int code(final int loc) throws CodeTooSmallError {
		int loc1 = loc;
		Routine routine = IMLCompiler.getRoutineTable().getRoutine(
				ident.getValue().toString());
		IMLCompiler.setScope(routine.getScope());

		routine.setAddress(loc1);
		IMLCompiler.getVM().Enter(loc1++,
				routine.getInOutCopyCount() + cpsDecl.getCount(), 0);
		loc1 = param.codeIn(loc1, routine.getParamList().size(), 0);

		loc1 = cmd.code(loc1);

		loc1 = param.codeOut(loc1, routine.getParamList().size(), 0);

		IMLCompiler.getVM().Return(loc1++, 1);

		IMLCompiler.setScope(null);

		return loc1;
	}
}
