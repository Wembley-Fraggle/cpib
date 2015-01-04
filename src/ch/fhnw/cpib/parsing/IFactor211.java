package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

public interface IFactor211 extends IConcSynNode {

	IExpr toAbsSyn(IToken ident);

}
