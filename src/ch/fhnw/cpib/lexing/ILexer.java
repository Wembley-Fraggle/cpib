package ch.fhnw.cpib.lexing;

import java.io.InputStream;
import java.util.List;

public interface ILexer {
	List<IToken> consume(InputStream text);
}
