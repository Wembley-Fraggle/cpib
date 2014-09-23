package ch.fhnw.cpib.model;

public interface ITokenList {

	void add(IToken.Base token);
	
	void reset();
	
	IToken.Base nextToken();
	
	String toString();
	
}
