package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface ITerm12 extends IConcSynNode {
    public IExpr toAbsSyn(IExpr left);

		public String toString(String indent);
}
