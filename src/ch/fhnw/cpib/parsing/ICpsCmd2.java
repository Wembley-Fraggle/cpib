package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;

public interface ICpsCmd2 extends IConcSynNode {

		String toString(String indent);

		ICmd toAbsSyn();

}
