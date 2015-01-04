package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.context.Routine.RoutineTypes;
import ch.fhnw.cpib.context.Store;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp;

public final class GlobImp implements IGlobImp {
	private final IFlowmode flowMode;
	private final IChangemode changeMode;
	private final IToken ident;
	private final IGlobImp globImp;

	public GlobImp(final IFlowmode flowMode, final IChangemode changeMode,
			final IToken ident, final IGlobImp globImp) {
		this.flowMode = flowMode;
		this.changeMode = changeMode;
		this.ident = ident;
		this.globImp = globImp;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<GlobImp>\n" + flowMode.toString(indent + '\t')
				+ changeMode.toString(indent + '\t') + ident.toString(indent + '\t')
				+ globImp.toString(indent + '\t') + indent + "</GlobImp>\n";
	}

	@Override
	public int getLine() {
		return ident.getStart().getCurrentLine();
	}

	@Override
	public void check(final Routine routine) throws ContextError {
		Store globalStore = IMLCompiler.getGlobalStoreTable().getStore(
				ident.getValue().toString());

		if (globalStore == null) {
			throw new ContextError("Global import is not declared! Ident: "
					+ ident.getValue(), ident.getStart().getCurrentLine());
		}

		if (globalStore.isConst() && changeMode.getMode().getType().isType("CONST")) {
			throw new ContextError(
					"Cannot import global constant as variable! Ident: "
							+ ident.getValue(), ident.getStart().getCurrentLine());
		}

		Store localStore = new Store(globalStore.getIdent(), globalStore.getType(),
				changeMode.getMode().getType().isType("CONST"));

		localStore.setAddress(globalStore.getAddress());
		localStore.setReference(false);
		localStore.setRelative(false);

		if (!IMLCompiler.getScope().getStoreTable().addStore(localStore)) {
			throw new ContextError("Global ident already used! Ident: "
					+ ident.getValue(), ident.getStart().getCurrentLine());
		}

		switch (flowMode.getMode().getType().getName()) {
		case "IN":
			localStore.initialize();
			break;
		case "INOUT":
			if (routine.getRoutineType() != RoutineTypes.PROCEDURE) {
				throw new ContextError("FlowMode INOUT is not allowed for functions! "
						+ "Ident: " + ident.getValue(), ident.getStart().getCurrentLine());
			}
			if (changeMode.getMode().getType().isType("CONST")) {
				throw new ContextError(
						"ChangeMode CONST is not allowed for FlowMode INOUT! " + "Ident: "
								+ ident.getValue(), ident.getStart().getCurrentLine());
			}
			localStore.initialize();
			break;
		case "OUT":
			if (routine.getRoutineType() != RoutineTypes.PROCEDURE) {
				throw new ContextError(
						"FlowMode OUT is not allowed for functions! Ident: "
								+ ident.getValue(), ident.getStart().getCurrentLine());
			}
			break;
		default:
			throw new RuntimeException();
		}

		routine.addGlobImp(new ch.fhnw.cpib.context.GlobImp(flowMode,
				changeMode, ident.getValue().toString()));

		globImp.check(routine);
	}

	@Override
	public void checkInit() throws ContextError {
		if (flowMode.getMode().getType().isType("OUT")) {
			if (!IMLCompiler.getScope().getStoreTable()
					.getStore(ident.getValue().toString()).isInitialized()) {
				throw new ContextError(
						"OUT global import is never initialized! Ident: "
								+ ident.getValue(), ident.getStart().getCurrentLine());
			}
		}

		globImp.checkInit();
	}
}
