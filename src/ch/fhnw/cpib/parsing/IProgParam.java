package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;

public interface IProgParam extends IConcSynNode {
    IDecl toAbsSyn();
	String toString(String indent);

}
