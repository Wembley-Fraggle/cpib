import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.errors.GrammarError;
import ch.fhnw.cpib.errors.LexicalError;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.IlmLexer;
import ch.fhnw.cpib.lexing.LexerContext;
import ch.fhnw.cpib.lexing.LexerException;
import ch.fhnw.cpib.lexing.LexerRuleFactory;
import ch.fhnw.cpib.parsing.IParser;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ContextError;
import ch.fhnw.cpib.parsing.impl.Parser;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.ExecutionError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public class TestOfMine {

	public TestOfMine() {
		try {
			IMLCompiler.compile("");
		} catch (LexicalError | GrammarError | ContextError | HeapTooSmallError
				| CodeTooSmallError | ExecutionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	File f = new File(
				"resource/TestFile.txt");
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
			IParser parser = new Parser(ctx.getTokens());
			parser.parse();
		} catch (IOException | LexerException e) {
			e.printStackTrace();
		} catch (GrammarError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	public static void main(String[] args) {
		new TestOfMine();
	}

}
