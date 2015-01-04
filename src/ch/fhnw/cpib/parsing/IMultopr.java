package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;

public interface IMultopr extends IConcSynNode {

    IToken toAbsSyn();

		String toString(String indent);

}
