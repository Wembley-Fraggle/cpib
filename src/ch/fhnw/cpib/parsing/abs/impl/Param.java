package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.context.Store;
import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IMechmode;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class Param implements IParam {
	private final IFlowmode flowMode;
	private final IMechmode mechMode;
	private final IStoreDecl storeDecl;
	private final IParam param;
	private Store store;

	public Param(final IFlowmode flowMode, final IMechmode mechMode,
			final IStoreDecl storeDecl, final IParam param) {
		this.flowMode = flowMode;
		this.mechMode = mechMode;
		this.storeDecl = storeDecl;
		this.param = param;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<Param>\n" + flowMode.toString(indent + '\t')
				+ mechMode.toString(indent + '\t') + storeDecl.toString(indent + '\t')
				+ param.toString(indent + '\t') + indent + "</Param>\n";
	}

	@Override
	public int getLine() {
		return storeDecl.getLine();
	}

	@Override
	public void checkInit() throws ContextError {
		if (flowMode.getMode().getType().isType("OUT")) {
			if (!IMLCompiler.getScope().getStoreTable()
					.getStore(storeDecl.getIdent()).isInitialized()) {
				throw new ContextError("OUT parameter is never initialized! Ident: "
						+ storeDecl.getIdent(), storeDecl.getLine());
			}
		}

		param.checkInit();
	}

	@Override
	public int calculateAddress(final int count, final int locals) {
		int locals1 = locals;
		if (flowMode.getMode().getType().isType("IN")
				|| mechMode.getMode().getType().isType("REF")) {
			store.setAddress(-count);
			store.setRelative(true);
			if (mechMode.getMode().getType().isType("REF")) {
				store.setReference(true);
			} else {
				store.setReference(false);
			}

		} else {
			store.setAddress(2 + ++locals1);
			store.setRelative(true);
			store.setReference(false);
		}
		return param.calculateAddress(count - 1, locals1);
	}

	@Override
	public int codeIn(final int loc, final int count, final int locals)
			throws CodeTooSmallError {
		int locals1 = locals;
		int loc1 = loc;
		if (flowMode.getMode().getType().isType("IN")
				&& mechMode.getMode().getType().isType("COPY")) {
			if (flowMode.getMode().getType().isType("INOUT")) {
				IMLCompiler.getVM().CopyIn(loc1++, -count, 3 + locals1);
			}
			locals1++;
		}
		return param.codeIn(loc1, count - 1, locals1);
	}

	@Override
	public int codeOut(final int loc, final int count, final int locals)
			throws CodeTooSmallError {
		int locals1 = locals;
		int loc1 = loc;
		if (flowMode.getMode().getType().isType("IN")
				&& mechMode.getMode().getType().isType("COPY")) {
			IMLCompiler.getVM().CopyOut(loc1++, 2 + ++locals1, -count);
		}
		return param.codeOut(loc1, count - 1, locals1);
	}

	@Override
	public void check(Routine routine) throws ContextError {
		// TODO Auto-generated method stub

	}
}
