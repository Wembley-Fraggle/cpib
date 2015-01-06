package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public interface ICParam extends IConcSynNode{

	String toString(String indent);

    IParam toAbsSyn(IParam absSyn);

}
