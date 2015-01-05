package ch.fhnw.cpib.parsing;

public interface ICProgram extends IConcSynNode {

	String toString(String indent);

	ch.fhnw.cpib.parsing.abs.IAbstSyn.IProgram toAbstrSyntax();

}
