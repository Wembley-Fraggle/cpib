package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface IFactor extends IConcSynNode {
    public IExpr toAbsSyn();

		public String toString(String indent);
}
