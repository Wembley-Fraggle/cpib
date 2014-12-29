package ch.fhnw.cpib.lexing;

import java.util.LinkedList;
import java.util.List;

public class LexerRuleFactory {
    
    public List<ITerminal> create() {
        
        LinkedList<ITerminal> types = new LinkedList<>();
       
        types.add(new Terminal("WS", "\\s+",true));
        types.add(new Terminal("IDENT", "[a-zA-Z][a-zA-Z0-9]*"));
        types.add(new Terminal("LPAREN", "\\("));
        types.add(new Terminal("RPAREN", "\\)"));  
        types.add(new Terminal("COMMA",","));  
        types.add(new Terminal("SEMI", ";"));  
        types.add(new Terminal("COLON", ":"));  
        types.add(new Terminal("BECOMES",":="));  
        types.add(new Terminal("TIMES", "\\*"));
        types.add(new Terminal("PLUS", "\\+"));
        types.add(new Terminal("MINUS", "-"));
        types.add(new Terminal("EQ", "="));
        types.add(new Terminal("NE", "/="));
        types.add(new Terminal("LT", "<"));
        types.add(new Terminal("GT", ">"));
        types.add(new Terminal("LE", "<="));
        types.add(new Terminal("GE", ">="));
        types.add(new Terminal("AND", "&&"));
        types.add(new Terminal("OR", "||"));
        types.add(new Terminal("NOT", "!"));
        types.add(new Terminal("CAND", "&?"));
        types.add(new Terminal("COR", "|\\?"));
        types.add(new Terminal("BOOLTYPE", "bool"));
        types.add(new Terminal("INTTYPE", "int32"));
        types.add(new Terminal("CALL", "call"));
        types.add(new Terminal("CONST", "const"));
        types.add(new Terminal("VAR", "var"));
        types.add(new Terminal("COPY", "copy"));
        types.add(new Terminal("REF", "ref"));
        types.add(new Terminal("DEBUGIN", "debugin"));
        types.add(new Terminal("DEBUGOUT", "debugout"));
        types.add(new Terminal("DIV", "div"));
        types.add(new Terminal("MOD", "mod"));
        types.add(new Terminal("DO", "do"));
        types.add(new Terminal("ELSE", "else"));
        types.add(new Terminal("ENDFUN", "endfun"));
        types.add(new Terminal("ENDIF", "endif"));
        types.add(new Terminal("ENDPROC", "endproc"));
        types.add(new Terminal("ENDPROGRAM", "endprogram"));
        types.add(new Terminal("ENDWHILE", "endwhile"));
        types.add(new Terminal("FALSE", "false"));
        types.add(new Terminal("TRUE", "true"));
        types.add(new Terminal("FUN", "fun"));
        types.add(new Terminal("GLOBAL", "global"));
        types.add(new Terminal("IF", "if"));
        types.add(new Terminal("IN", "in"));
        types.add(new Terminal("INOUT", "inout"));
        types.add(new Terminal("OUT", "out"));
        types.add(new Terminal("INIT", "init"));
        types.add(new Terminal("INTVAL", "[0-9]+"));
        types.add(new Terminal("COMMENT"));
        types.add(new Terminal("BLOCKCOMMENT","/\\*.*?\\*/"),,true);
        types.add(new Terminal("LINECOMMENT","//.*\n",true));
        
        return types;
    }
    
}
