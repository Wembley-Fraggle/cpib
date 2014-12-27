package ch.fhnw.cpib.parsing;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ch.fhnw.cpib.DragonGrammar;
import ch.fhnw.cpib.lexing.EndMarker;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.Token;
import ch.fhnw.cpib.parsing.tools.FirstAnalyser;
import ch.fhnw.cpib.parsing.tools.FollowAnalyser;
import ch.fhnw.cpib.parsing.tools.NullableCheck;
import ch.fhnw.cpib.parsing.tools.ParserTable;
import ch.fhnw.cpib.parsing.tools.ParserTableBuilder;

public class ParserTest {

    @Test
    public void test() throws ParserException {
       DragonGrammar grammer = new DragonGrammar();
       NullableCheck nullableAnalyser = new NullableCheck(grammer);
       FirstAnalyser firstAnalyser = new FirstAnalyser(grammer);
       FollowAnalyser followAnalyser = new FollowAnalyser(grammer);
       
       firstAnalyser.setNullableAnalyser(nullableAnalyser);
       followAnalyser.setNullableAnalyser(nullableAnalyser);
       followAnalyser.setFirstAnalyser(firstAnalyser);
       
       ParserTable table = new ParserTableBuilder()
       .grammar(grammer)
       .nullable(nullableAnalyser)
       .first(firstAnalyser)
       .follow(followAnalyser)
       .build();
       
       List<IToken> input = new LinkedList<>();
       
       input.add(new Token(grammer.getId(),"id"));
       input.add(new Token(grammer.getPlus(),"+"));
       input.add(new Token(grammer.getId(),"id"));
       input.add(new Token(grammer.getTimes(),"*"));
       input.add(new Token(grammer.getId(),"id"));
       input.add(new Token(new EndMarker(),"<$>"));
       
       ConcreteParserTree concreteTree = new ConcreteParserTree();
       Parser parser = new Parser();
       parser
       .grammar(grammer)
       .parserTable(table)
       .notifyEvent(new ParserEventLogger())
       .notifyEvent(concreteTree)
       .input(input)
       .build();
    }

}
