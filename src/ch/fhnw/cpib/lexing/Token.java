package ch.fhnw.cpib.lexing;


public class Token implements IToken{

    private ITokenType type;
    private IPosition start;
    private CharSequence value;

    public Token(ITokenType type,IPosition start, CharSequence value) {
        this.type = type;
        this.start = start;
        this.value = value;
    }
    
    
    @Override
    public IPosition getStart() {
        return start;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append("\"").append(value).append("\" : ");
        builder.append(type.getName()).append(" ");
        builder.append(start);
        builder.append(")");
        
        return builder.toString();
    }


    @Override
    public CharSequence getValue() {
        return this.value;
    }


    @Override
    public ITokenType getType() {
        return type;
    }
}
