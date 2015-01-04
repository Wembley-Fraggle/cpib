package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.context.Modes;

public interface IFlowmode extends IConcSynNode {
	String toString(String indent);
	Modes getMode();
}
