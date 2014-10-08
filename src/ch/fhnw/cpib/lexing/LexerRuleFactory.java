package ch.fhnw.cpib.lexing;

import java.util.LinkedList;
import java.util.List;

public class LexerRuleFactory {
    
    public List<ITokenType> create() {
        
        LinkedList<ITokenType> types = new LinkedList<>();
       
        types.add(new TokenType("WS", "\\s+",true));
        types.add(new TokenType("IDENTIFIER", "[a-zA-Z][a-zA-Z0-9]*"));
        types.add(new TokenType("LPAREN", "\\("));
        types.add(new TokenType("RPAREN", "\\)"));  
        types.add(new TokenType("COMMA",","));  
        types.add(new TokenType("SEMICOLON", ";"));  
        types.add(new TokenType("COLON", ":"));  
        types.add(new TokenType("BECOMES",":="));  
        types.add(new TokenType("TIMES", "\\*"));
        types.add(new TokenType("PLUS", "\\+"));
        types.add(new TokenType("MINUS", "-"));
        types.add(new TokenType("EQ", "="));
        types.add(new TokenType("NE", "/="));
        types.add(new TokenType("LT", "<"));
        types.add(new TokenType("GT", ">"));
        types.add(new TokenType("LE", "<="));
        types.add(new TokenType("GE", ">="));
        types.add(new TokenType("AND", "&&"));
        types.add(new TokenType("OR", "||"));
        types.add(new TokenType("NOT", "!"));
        types.add(new TokenType("CAND", "&?"));
        types.add(new TokenType("COR", "|\\?"));
        types.add(new TokenType("BOOLTYPE", "bool"));
        types.add(new TokenType("INTTYPE", "int32"));
        types.add(new TokenType("CALL", "call"));
        types.add(new TokenType("CONST", "const"));
        types.add(new TokenType("VAR", "var"));
        types.add(new TokenType("COPY", "copy"));
        types.add(new TokenType("REF", "ref"));
        types.add(new TokenType("DEBUGIN", "debugin"));
        types.add(new TokenType("DEBUGOUT", "debugout"));
        types.add(new TokenType("DIV", "div"));
        types.add(new TokenType("MOD", "mod"));
        types.add(new TokenType("DO", "do"));
        types.add(new TokenType("ELSE", "else"));
        types.add(new TokenType("ENDFUN", "endfun"));
        types.add(new TokenType("ENDIF", "endif"));
        types.add(new TokenType("ENDPROC", "endproc"));
        types.add(new TokenType("ENDPROGRAM", "endprogram"));
        types.add(new TokenType("ENDWHILE", "endwhile"));
        types.add(new TokenType("FALSE", "false"));
        types.add(new TokenType("TRUE", "true"));
        types.add(new TokenType("FUN", "fun"));
        types.add(new TokenType("GLOBAL", "global"));
        types.add(new TokenType("IF", "if"));
        types.add(new TokenType("IN", "in"));
        types.add(new TokenType("INOUT", "inout"));
        types.add(new TokenType("OUT", "out"));
        types.add(new TokenType("INIT", "init"));
        types.add(new TokenType("INTVAL", "[0-9]+"));
        types.add(new TokenType("COMMENT"));
        types.add(new TokenType("BLOCKCOMMENT","/\\*.*?\\*/"));
        types.add(new TokenType("LINECOMMENT","//.*\n"));
        
        return types;
    }
    
}
