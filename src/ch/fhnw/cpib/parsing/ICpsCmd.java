package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn;


//TODO Auto-generated stub
public interface ICpsCmd extends IConcSynNode {

    IAbstSyn.ICmd toAbsSyn();

		String toString(String indent);
}
