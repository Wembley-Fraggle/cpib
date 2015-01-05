package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;

public interface ICmd4 extends IConcSynNode, ICCmd {
    public ICmd toAbsSyn();

		String toString(String indent);
}
