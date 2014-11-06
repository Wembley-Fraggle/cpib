package ch.fhnw.cpib.parsing.nodes;


public class Terminal extends AbstractProductionNode implements ITerminal {
    
    public Terminal(String name) {
        super(name);
    }
    
    public Terminal(Terminal tokenType) {
        super(tokenType.getName());
    }
}
