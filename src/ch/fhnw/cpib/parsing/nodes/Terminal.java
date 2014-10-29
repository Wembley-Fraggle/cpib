package ch.fhnw.cpib.parsing.nodes;

import ch.fhnw.cpib.lexing.TokenType;

public class Terminal extends AbstractProductionNode implements ITerminal {
    
    public Terminal(String name) {
        super(name);
    }
    
    public Terminal(TokenType tokenType) {
        super(tokenType.getName());
    }
}
