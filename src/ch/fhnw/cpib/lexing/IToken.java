package ch.fhnw.cpib.lexing;

public interface IToken {
	IPosition getStart();
	int getLength();
	Object getAttribute();
}
