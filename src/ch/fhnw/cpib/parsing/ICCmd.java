package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;

public interface ICCmd extends IConcSynNode {

    ICmd toAbsSyn();

	String toString(String indent);

}
