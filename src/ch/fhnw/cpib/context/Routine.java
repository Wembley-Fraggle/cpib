package ch.fhnw.cpib.context;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public abstract class Routine extends Symbol {

	private Scope scope;
	private RoutineTypes routineType;
	private List<Parameter> paramList = new ArrayList<Parameter>();
	private List<GlobImp> globImpList = new ArrayList<GlobImp>();
	private List<Integer> calls = new ArrayList<Integer>();
	private int address;

	protected Routine(final String ident, final ITerminal type,
			final RoutineTypes routineType) {
		super(ident, type);
		this.routineType = routineType;
		this.scope = new Scope();
	}

	public final void setAddress(final int address) {
		this.address = address;
	}

	public final void addCall(final int loc) {
		calls.add(loc);
	}

	public final void codeCalls() throws CodeTooSmallError {
		for (int loc : calls) {
			IMLCompiler.getVM().Call(loc, address);
		}
	}

	public final Scope getScope() {
		return scope;
	}

	public final RoutineTypes getRoutineType() {
		return routineType;
	}

	public final List<Parameter> getParamList() {
		return paramList;
	}

	public final int getInOutCopyCount() {
		int count = 0;
		for (Parameter param : paramList) {
			if (param.getMechMode().getMode() == Modes.COPY
					&& param.getFlowMode().getMode() == Modes.IN) {
				count++;
			}
		}
		return count;
	}

	public final List<GlobImp> getGlobImpList() {
		return globImpList;
	}

	public final void addParam(final Parameter param) {
		paramList.add(param);
	}

	public final void addGlobImp(final GlobImp globImp) {
		globImpList.add(globImp);
	}

	public enum RoutineTypes {
		FUNCTION, PROCEDURE
	}
}
