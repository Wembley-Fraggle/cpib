package ch.fhnw.cpib.parsing.nodes;

import ch.fhnw.cpib.lexing.Terminal;

public class Terminal extends AbstractProductionNode implements ITerminal {
    
    public Terminal(String name) {
        super(name);
    }
    
    public Terminal(Terminal tokenType) {
        super(tokenType.getName());
    }
}
