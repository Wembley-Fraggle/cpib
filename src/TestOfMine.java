import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import ch.fhnw.cpib.errors.GrammarError;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.IlmLexer;
import ch.fhnw.cpib.lexing.LexerContext;
import ch.fhnw.cpib.lexing.LexerException;
import ch.fhnw.cpib.lexing.LexerRuleFactory;
import ch.fhnw.cpib.parsing.IParser;
import ch.fhnw.cpib.parsing.IProgram;
import ch.fhnw.cpib.parsing.as.IAbsMother;
import ch.fhnw.cpib.parsing.as.impl.AbsMother;
import ch.fhnw.cpib.parsing.impl.Parser;

public class TestOfMine {

	public TestOfMine() {
		File f = new File(
				"C:\\FHNW\\7-Semester\\cpib\\workspace\\cpib\\TestFile.txt");
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream(f);
			fis2 = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			LexerRuleFactory builder = new LexerRuleFactory();
			List<ITerminal> syntax = builder.create();
			IlmLexer lexer = new IlmLexer(syntax);
			LexerContext ctx = new LexerContext(fis2);
			for (IToken k : lexer.consume(fis)) {
				ctx.addToken(k);
			}
			for (IToken t : ctx.getTokens()) {
				System.out.println(t);
			}
			System.out.println("*************************CONCRETE SYNTAX*************************");
			IParser parser = new Parser(ctx.getTokens());
			IProgram prog = parser.parse();
			System.out.println("*************************ABSTRACT SYNTAX*************************");
			IAbsMother mother = prog.toAbsSyn();
			System.out.println(mother.toString(""));
		} catch (IOException | LexerException e) {
			e.printStackTrace();
		} catch (GrammarError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestOfMine();
	}

}
