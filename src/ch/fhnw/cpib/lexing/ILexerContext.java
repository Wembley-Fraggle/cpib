package ch.fhnw.cpib.lexing;

import java.util.List;

public interface ILexerContext {
	IPosition getCurrentPosition();
	void movePosition(int count);
	void addToken(IToken token);
	List<IToken> getTokens();
	CharSequence getText();
}
