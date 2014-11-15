package ch.fhnw.cpib.parsing;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.IProduction;

public class ParserEventListenerAdapter implements IParserEventListener{

    @Override
    public void onStart() {
    }

    @Override
    public void output(IProduction production) {
    }

    @Override
    public void output(IToken token) {
    }

    @Override
    public void onEnd() {
    }

}
