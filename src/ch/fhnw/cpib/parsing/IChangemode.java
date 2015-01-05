package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.context.Modes;

public interface IChangemode extends IConcSynNode {
	String toString(String indent);

	Modes getMode();
}
