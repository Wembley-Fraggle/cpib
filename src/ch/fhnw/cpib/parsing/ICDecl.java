package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

//TODO Auto-generated stub
public interface ICDecl extends IConcSynNode {

	String toString(String indent);

	IDecl toAbsSyn();

}
