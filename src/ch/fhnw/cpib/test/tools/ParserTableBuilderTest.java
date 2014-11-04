package ch.fhnw.cpib.test.tools;

import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.parsing.ParserException;
import ch.fhnw.cpib.parsing.tools.ParserTable;
import ch.fhnw.cpib.parsing.tools.ParserTableBuilder;
import ch.fhnw.cpib.test.DragonGrammar;

public class ParserTableBuilderTest {
    private DragonGrammar grammar;
    private ParserTableBuilder builder; 
    
    @Before
    public void setup() {
        grammar = new DragonGrammar();
        builder = new ParserTableBuilder();
    }
    
    @Test
    public void test() throws ParserException{
        ParserTable pt = builder.grammar(grammar).build();
        System.out.println(pt);
    }
}
