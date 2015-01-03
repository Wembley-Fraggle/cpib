package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsExpr;

public interface IFactor21 extends IConcSynNode, IFactor {

	IAbsExpr toAbsSyn(IToken ident);

}
