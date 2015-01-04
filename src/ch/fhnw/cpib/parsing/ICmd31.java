package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.as.IAbsInvariant;

public interface ICmd31 extends IConcSynNode {

    IAbsInvariant toAbsSyn();

		String toString(String indent);

}
