package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.context.Modes;
import ch.fhnw.cpib.lexing.IToken;

//TODO Auto-generated stub
public interface IChangemode extends IConcSynNode {
	String toString(String indent);

	Modes getMode();
}
