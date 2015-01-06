import java.io.FileNotFoundException;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.errors.GrammarError;
import ch.fhnw.cpib.errors.LexicalError;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ContextError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.ExecutionError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public class TestOfMine {

	public TestOfMine(String path) {
		try {
			// try {
			// IMLCompiler.setVm(new VirtualMachineFile("resource/Sample.iml"));
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			IMLCompiler.compile(path);
		} catch (LexicalError | GrammarError | ContextError | HeapTooSmallError
				| CodeTooSmallError | ExecutionError | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * File f = new File( "resource/TestFile.txt"); FileInputStream fis = null;
		 * FileInputStream fis2 = null; try { fis = new FileInputStream(f); fis2 =
		 * new FileInputStream(f); } catch (FileNotFoundException e1) {
		 * e1.printStackTrace(); } try { LexerRuleFactory builder = new
		 * LexerRuleFactory(); List<ITerminal> syntax = builder.create(); IlmLexer
		 * lexer = new IlmLexer(syntax); LexerContext ctx = new LexerContext(fis2);
		 * for (IToken k : lexer.consume(fis)) { ctx.addToken(k); } for (IToken t :
		 * ctx.getTokens()) { System.out.println(t); } IParser parser = new
		 * Parser(ctx.getTokens()); parser.parse(); } catch (IOException |
		 * LexerException e) { e.printStackTrace(); } catch (GrammarError e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			new TestOfMine(args[0]);
		} else {
			new TestOfMine("");
		}
	}

}
