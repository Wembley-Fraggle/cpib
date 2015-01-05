package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;

public interface IRelopr extends IConcSynNode {
    IToken toAbsSyn();

		String toString(String indent);
}
