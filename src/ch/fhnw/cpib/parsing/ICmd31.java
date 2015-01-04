package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDbcCmd;

public interface ICmd31 extends IConcSynNode {

    IDbcCmd toAbsSyn();

    String toString(String indent);

}
