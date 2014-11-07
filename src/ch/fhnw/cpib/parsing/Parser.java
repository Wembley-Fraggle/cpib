package ch.fhnw.cpib.parsing;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.lexing.IPosition;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.EndMarker;
import ch.fhnw.cpib.parsing.nodes.IEmptyWord;
import ch.fhnw.cpib.parsing.nodes.IEndMarker;
import ch.fhnw.cpib.parsing.nodes.INonTerminal;
import ch.fhnw.cpib.parsing.nodes.IProduction;
import ch.fhnw.cpib.parsing.nodes.IProductionNode;
import ch.fhnw.cpib.parsing.tools.ParserTable;

public class Parser {
    private IGrammar grammar;
    private ParserTable parserTable;
    private List<IToken> input;
    private static Logger logger = Logger.getLogger(Parser.class);

    public Parser grammar(IGrammar grammar) {
        this.grammar = grammar;
        return this;
    }

    public Parser parserTable(ParserTable table) {
        this.parserTable = table;
        return this;
    }

    public Parser input(List<IToken> tokens) {
        this.input = new LinkedList<>(tokens);
        return this;
    }

    public void build() throws ParserException {
        if (this.grammar == null) {
            throw new IllegalStateException("Grammar not set");
        }
        if(grammar.getStartSymbol() == null) {
            throw new IllegalStateException("Grammar has no start symbol");
        }
        if (this.parserTable == null) {
            throw new IllegalStateException("ParserTable not set");
        }
        if (input == null) {
            throw new IllegalStateException("Input not set yet");
        }
        if (input.size() == 0) {
            throw new IllegalArgumentException("Input is empty");
        }
        
        IToken lastToken = input.get(input.size()-1);
        if(!(lastToken.getType() instanceof IEndMarker)) {
            throw new IllegalArgumentException("Endmarker at the end of the input expected");
        }

        buildParsreTree(); // TODO Returned result?
    }

    private void buildParsreTree() throws ParserException {
        EndMarker endMarker = new EndMarker();
        
        Stack<IProductionNode> stack = new Stack<>();
        stack.push(endMarker); 
       
        stack.push(grammar.getStartSymbol());
        IToken nextToken = input.get(0);
        
        // TODO refactor this
        while (!stack.isEmpty()) {
            IProductionNode node = stack.peek(); // TODO Make it typesafe
            if (node instanceof IEndMarker) {
                stack.pop();
                if(input.size() != 1) {
                    throwInvalidToken(input.get(0));
                }
            }
            else if (node instanceof ITerminal) {
                ITerminal terminal = (ITerminal) node;
                if (terminal.getName().equals(nextToken.getType().getName())) {
                    // TODO Better use directly Terminals for input directly
                    logger.debug("Match " + nextToken); // TODO
                    stack.pop();
                    input.remove(0);
                    nextToken = input.get(0);
                } else {
                    throwInvalidToken(nextToken);
                }
            } else if (node instanceof INonTerminal) {
                INonTerminal nonTerminal = (INonTerminal) node;
                ITerminal terminal = nextToken.getType();
                IProduction p = parserTable.get(nonTerminal, terminal); 
                if (p == null) {
                    throwInvalidToken(nextToken);
                } else {
                    logger.debug("Output: " + p); // TODO
                    stack.pop();
                    List<IProductionNode> body = p.getBody();
                    for (int i = body.size() - 1; i >= 0; i--) {
                        IProductionNode bodyNode = body.get(i);
                        if(!(bodyNode instanceof IEmptyWord)) {
                            stack.push(bodyNode);
                        }
                        
                    }
                }
            }
            
        }
        
        // TODO What about events in order to produce the tree?
    }

    private void throwInvalidToken(IToken nextToken) throws ParserException {
        IPosition pos = nextToken.getStart();
        StringBuilder builder = new StringBuilder();
        builder.append("Invalid token '").append(nextToken.getValue());
        if(pos != null) {
            builder
            .append("' at line ").append(pos.getCurrentLine())
            .append(" Column ").append(pos.getCurrentColumn());
        }
                
        throw new ParserException(builder.toString());
    }
}
