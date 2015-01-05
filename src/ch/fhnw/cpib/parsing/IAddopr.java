package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;

public interface IAddopr extends IConcSynNode {
    public IToken toAbsSyn();

		public String toString(String indent);
}
