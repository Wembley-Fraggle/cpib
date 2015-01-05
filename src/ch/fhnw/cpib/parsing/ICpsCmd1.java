package ch.fhnw.cpib.parsing;


public interface ICpsCmd1 extends IConcSynNode {

	ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsCmd toAbsSyn();

	String toString(String indent);

}
