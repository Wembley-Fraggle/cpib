package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn;


public interface IFunDecl extends IConcSynNode {
	public String toString(String indent);
	
	public IAbstSyn.IDecl toAbsSyn();
}
