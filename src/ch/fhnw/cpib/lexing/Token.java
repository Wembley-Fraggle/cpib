package ch.fhnw.cpib.lexing;

import java.security.KeyStore.Entry.Attribute;
import java.util.LinkedList;
import java.util.List;

public class Token implements IToken{

    private String name;
    private IPosition start;
    private int length;
    private Object argument;
    
    
    public Token(String name, IPosition start, int length) {
        this(name,start,length,null);
    }
    
    public Token(String name, IPosition start, int length,  Object arguments) {
        this.name = name;
        this.start = start;
        this.length = length;
        this.argument = arguments;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public IPosition getStart() {
        return start;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Object getAttribute() {
        return this.argument;
    }
    
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean hasArguments = this.argument != null;
        if(hasArguments) {
            builder.append("(");
        }
        builder.append(name);
        
        if(hasArguments) {
            builder.append(" ,");
            builder.append(argument.toString());
        }
         
        if(hasArguments) {
            builder.append(")");
        }
        return builder.toString();
    }
}
