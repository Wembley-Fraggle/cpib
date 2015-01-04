package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Scope;
import ch.fhnw.cpib.context.Store;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CmdIf implements ICmd {
	private final IExpr expr;
	private final ICmd ifCmd;
	private final ICmd elseCmd;

	public CmdIf(final IExpr expr, final ICmd ifCmd, final ICmd elseCmd) {
		this.expr = expr;
		this.ifCmd = ifCmd;
		this.elseCmd = elseCmd;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<CmdIf>\n" + expr.toString(indent + '\t')
				+ ifCmd.toString(indent + '\t') + elseCmd.toString(indent + '\t')
				+ indent + "</CmdIf>\n";
	}

	@Override
	public int getLine() {
		return expr.getLine();
	}

	@Override
	public void check(final boolean canInit) throws ContextError {
		if (!expr.checkR().isType("BOOL")) {
			throw new ContextError("IF condition must be a boolean! ", expr.getLine());
		}

		Scope parentScope = IMLCompiler.getScope();
		Scope ifScope = new Scope(parentScope.getStoreTable().clone());
		Scope elseScope = new Scope(parentScope.getStoreTable().clone());

		IMLCompiler.setScope(ifScope);
		ifCmd.check(canInit);
		IMLCompiler.setScope(elseScope);
		elseCmd.check(canInit);

		for (Store store : parentScope.getStoreTable().getTable().values()) {
			if (!store.isInitialized()) {
				Store storeIf = ifScope.getStoreTable().getStore(store.getIdent());
				Store storeElse = elseScope.getStoreTable().getStore(store.getIdent());

				if (storeIf.isInitialized() != storeElse.isInitialized()) {
					throw new ContextError(
							"Initialization must happen in both branches of an"
									+ " IF command! Ident: " + store.getIdent(), expr.getLine());
				}

				if (storeIf.isInitialized()) {
					store.initialize();
				}
			}
		}

		IMLCompiler.setScope(parentScope);
	}

	@Override
	public int code(final int loc) throws CodeTooSmallError {
		int loc1 = expr.code(loc);
		int loc2 = loc1 + 1;
		IMLCompiler.getVM().CondJump(loc1, loc2 + 1);
		int loc3 = ifCmd.code(loc2);
		int loc4 = elseCmd.code(loc3);
		return loc4;
	}
}
