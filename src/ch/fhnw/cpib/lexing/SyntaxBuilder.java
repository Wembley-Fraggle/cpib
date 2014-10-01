package ch.fhnw.cpib.lexing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SyntaxBuilder {
    private Map<String, ITokenType> lookup;
    private List<ITokenType> types;
    
    public List<ITokenType> build() {
        
        types = new LinkedList<>();
        lookup = new HashMap<>();
        
        register(new TokenType("DATAOPERATOR"));
        register(new TokenType("TYPE"));
        register(new TokenType("FLOWMODE"));
        register(new TokenType("MECHMODE"));
        register(new TokenType("CHANGEMODE"));
        register(new TokenType("VALUE"));
        register(new TokenType("BOOLVAL"));
        register(new TokenType("MULTOPR"));
        register(new TokenType("ADDOPR"));
        register(new TokenType("RELOPR"));
        register(new TokenType("BOOLOPR"));
        register(new TokenType("WS", "\\s+"));
        register(new TokenType("IDENTIFIER", "[a-zA-Z][a-zA-Z0-9]*"));
        register(new TokenType("LPAREN", "\\("));
        register(new TokenType("RPAREN", "\\)"));  
        register(new TokenType("COMMA",","));  
        register(new TokenType("SEMICOLON", ";"));  
        register(new TokenType("COLON", ":"));  
        register(new TokenType("BECOMES",":="));  
        register(new TokenType("TIMES", "\\*"));
        register(new TokenType("PLUS", "\\+"));
        register(new TokenType("MINUS", "-"));
        register(new TokenType("EQ", "="));
        register(new TokenType("NE", "/="));
        register(new TokenType("LT", "<"));
        register(new TokenType("GT", ">"));
        register(new TokenType("LE", "<="));
        register(new TokenType("GE", ">="));
        register(new TokenType("AND", "&&"));
        register(new TokenType("OR", "||"));
        register(new TokenType("NOT", "!"));
        register(new TokenType("CAND", "&?"));
        register(new TokenType("COR", "|\\?"));
        register(new TokenType("BOOLTYPE", "bool"));
        register(new TokenType("INTTYPE", "int32"));
        register(new TokenType("CALL", "call"));
        register(new TokenType("CONST", "const"));
        register(new TokenType("VAR", "var"));
        register(new TokenType("COPY", "copy"));
        register(new TokenType("REF", "ref"));
        register(new TokenType("DEBUGIN", "debugin"));
        register(new TokenType("DEBUGOUT", "debugout"));
        register(new TokenType("DIV", "div"));
        register(new TokenType("MOD", "mod"));
        register(new TokenType("DO", "do"));
        register(new TokenType("ELSE", "else"));
        register(new TokenType("ENDFUN", "endfun"));
        register(new TokenType("ENDIF", "endif"));
        register(new TokenType("ENDPROC", "endproc"));
        register(new TokenType("ENDPROGRAM", "endprogram"));
        register(new TokenType("ENDWHILE", "endwhile"));
        register(new TokenType("FALSE", "false"));
        register(new TokenType("TRUE", "true"));
        register(new TokenType("FUN", "fun"));
        register(new TokenType("GLOBAL", "global"));
        register(new TokenType("IF", "if"));
        register(new TokenType("IN", "in"));
        register(new TokenType("INOUT", "inout"));
        register(new TokenType("OUT", "out"));
        register(new TokenType("INIT", "init"));
        register(new TokenType("INTVAL", "[0-9]+"));
        register(new TokenType("COMMENT"));
        register(new TokenType("BLOCKCOMMENT","/\\*.*\\*/"));
        register(new TokenType("LINECOMMENT","//.*\n"));
        
        lookup("MULTOPR").isA(lookup("DATAOPERATOR"));
        lookup("MOD").isA(lookup("DATAOPERATOR"));
        lookup("ADDOPR").isA(lookup("DATAOPERATOR"));
        lookup("RELOPR").isA(lookup("DATAOPERATOR"));
        lookup("BOOLOPR").isA(lookup("DATAOPERATOR"));
        
        lookup("BOOLTYPE").isA(lookup("TYPE"));
        lookup("INTTYPE").isA(lookup("TYPE"));
        
        lookup("IN").isA(lookup("FLOWMODE"));
        lookup("INOUT").isA(lookup("FLOWMODE"));
        lookup("OUT").isA(lookup("FLOWMODE"));
        
        lookup("COPY").isA(lookup("MECHMODE"));
        lookup("REF").isA(lookup("MECHMODE"));
        
        lookup("VAR").isA(lookup("CHANGEMODE"));
        lookup("REF").isA(lookup("CHANGEMODE"));
        
        lookup("BOOLVAL").isA(lookup("VALUE"));
        lookup("INTVAL").isA(lookup("VALUE"));
        
        lookup("TRUE").isA(lookup("BOOLVAL"));
        lookup("FALSE").isA(lookup("BOOLVAL"));
        
        lookup("TIMES").isA(lookup("MULTOPR"));
        lookup("DIV").isA(lookup("MULTOPR"));
        
        lookup("EQ").isA(lookup("RELOPR"));
        lookup("NE").isA(lookup("RELOPR"));
        lookup("LT").isA(lookup("RELOPR"));
        lookup("GT").isA(lookup("RELOPR"));
        lookup("LE").isA(lookup("RELOPR"));
        lookup("GE").isA(lookup("RELOPR"));
        
        lookup("NOT").isA(lookup("BOOLOPR"));
        lookup("AND").isA(lookup("BOOLOPR"));
        lookup("OR").isA(lookup("BOOLOPR"));
        lookup("CAND").isA(lookup("BOOLOPR"));
        lookup("COR").isA(lookup("BOOLOPR"));
        
        lookup("LINECOMMENT").isA(lookup("COMMENT"));
        lookup("BLOCKCOMMENT").isA(lookup("COMMENT"));
        
        lookup("WS").ignore(true);
        lookup("BLOCKCOMMENT").ignore(true);
        lookup("LINECOMMENT").ignore(true);
        
        return types;
    }
    
    private void register(ITokenType type) {
        lookup.put(type.getName(), type);
        types.add(type);
    }
    
    private ITokenType lookup(String name) {
        return this.lookup.get(name);
    }
}
