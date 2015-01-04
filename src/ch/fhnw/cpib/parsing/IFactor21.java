package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;


public interface IFactor21 extends IConcSynNode {
    public IExpr toAbsSyn(IToken ident);

		public String toString(String indent);
}
