package ch.fhnw.cpib.context;

import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IFlowmode;
import ch.fhnw.cpib.parsing.IMechmode;

public final class Parameter {
	private final IFlowmode flowMode;
	private final IMechmode mechMode;
	private final IChangemode changeMode;
	private final ITerminal type;

	public Parameter(final IFlowmode flowMode, final IMechmode mechMode,
			final IChangemode changeMode, final ITerminal type) {
		this.flowMode = flowMode;
		this.mechMode = mechMode;
		this.changeMode = changeMode;
		this.type = type;
	}

	public IFlowmode getFlowMode() {
		return flowMode;
	}

	public IMechmode getMechMode() {
		return mechMode;
	}

	public IChangemode getChangeMode() {
		return changeMode;
	}

	public ITerminal getType() {
		return type;
	}
}
