package ch.fhnw.cpib.parsing;

public interface IGlobImps1 extends IConcSynNode {

	String toString(String indent);

	ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp toAbsSyn(
			ch.fhnw.cpib.parsing.abs.IAbstSyn.IGlobImp absSyn);

}
