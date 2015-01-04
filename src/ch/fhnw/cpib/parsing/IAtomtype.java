package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;

public interface IAtomtype extends IConcSynNode {
    public IToken toAbsSyn();

		public String toString(String indent);
}
