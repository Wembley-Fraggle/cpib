package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.parsing.abs.IAbstSyn;


//TODO Auto-generated stub
public interface IFunDecl extends IConcSynNode {
	public String toString(String indent);
	
	public IAbstSyn.IDecl toAbsSyn();
}
