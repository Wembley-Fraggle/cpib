package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.IProduction;

public interface IParserEventListener {
    void onStart();
    void output(IProduction production);
    void output(IToken token);
    void onEnd();
}
