package ch.fhnw.cpib.lexing;

import java.util.LinkedList;
import java.util.List;

public class SyntaxBuilder {
    public ILexerState build() {
        
        ILexerState rootState = new LexerState();
        ITransition wsTransition = new WhiteSpaceTransition(rootState);
        ITransition idTransition = new IdentifierTransition(rootState);
        rootState.addTransition(wsTransition);
        rootState.addTransition(idTransition);
        
        // Block Comments
        ILexerState inComment = new LexerState();
        
        return rootState;
    }
}
