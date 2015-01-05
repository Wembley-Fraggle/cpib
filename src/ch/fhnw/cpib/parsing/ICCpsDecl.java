package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;

//TODO Auto-generated stub
public interface ICCpsDecl extends IConcSynNode {

	String toString(String indent);

	ICpsDecl toAbsSyn();

}
