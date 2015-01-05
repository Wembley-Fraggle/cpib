package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IParam;

public interface IProgParam extends IConcSynNode {
	IParam toAbsSyn(IParam iParam);
	String toString(String indent);

}
