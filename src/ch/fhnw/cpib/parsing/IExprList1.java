package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;

public interface IExprList1 extends IConcSynNode {
    public IExprList toAbsSyn();

		public String toString(String indent);
}
