package ch.fhnw.cpib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import ch.fhnw.cpib.context.RoutineTable;
import ch.fhnw.cpib.context.Scope;
import ch.fhnw.cpib.context.StoreTable;
import ch.fhnw.cpib.errors.GrammarError;
import ch.fhnw.cpib.errors.LexicalError;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.lexing.IlmLexer;
import ch.fhnw.cpib.lexing.LexerContext;
import ch.fhnw.cpib.lexing.LexerException;
import ch.fhnw.cpib.lexing.LexerRuleFactory;
import ch.fhnw.cpib.parsing.IProgram;
import ch.fhnw.cpib.parsing.abs.IAbstSyn;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ContextError;
import ch.fhnw.cpib.parsing.impl.Parser;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.ExecutionError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;
import ch.fhnw.lederer.virtualmachine.VirtualMachine;

public final class IMLCompiler {
	private static final int CODE_SIZE = 1000;
	private static final int STORE_SIZE = 1000;

	private static RoutineTable routineTable = new RoutineTable();
	private static StoreTable globalStoreTable = new StoreTable();
	private static Scope scope = null;
	private static IVirtualMachine vm = new VirtualMachine(CODE_SIZE, STORE_SIZE);

	public static RoutineTable getRoutineTable() {
		return routineTable;
	}

	public static void setVm(IVirtualMachine vm) {
		IMLCompiler.vm = vm;
	}

	public static StoreTable getGlobalStoreTable() {
		return globalStoreTable;
	}

	public static Scope getScope() {
		return scope;
	}

	public static void setScope(final Scope scope) {
		IMLCompiler.scope = scope;
	}

	public static IVirtualMachine getVM() {
		return vm;
	}

	private IMLCompiler() {
		throw new AssertionError("Instantiating utility class...");
	}

	public static synchronized void compile(final String imlCode)
			throws LexicalError, GrammarError, ContextError, HeapTooSmallError,
			CodeTooSmallError, ExecutionError {
		File f = new File(
				"resource/TestFile.txt");
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream(f);
			fis2 = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("Scanning:");
		LexerRuleFactory builder = new LexerRuleFactory();
		List<ITerminal> syntax = builder.create();
		IlmLexer lexer = new IlmLexer(syntax);
		LexerContext ctx;
		try {
			ctx = new LexerContext(fis2);
			for (IToken k : lexer.consume(fis)) {
				ctx.addToken(k);
			}
			List<IToken> tokenList = ctx.getTokens();
			System.out.println("Success!");
			System.out.println("\nTokenList:");
			for (IToken t : tokenList) {
				System.out.println(t);
			}
			System.out.println("\nParsing:");
			final Parser parser = new Parser(tokenList);
			final IProgram concSyn = parser.parse();
			System.out.println("\nSuccess!");
			System.out.println("\nConcrete syntax tree:");
			System.out.println(concSyn.toString(""));
			System.out.println("Generating abstract syntax tree:");
			final IAbstSyn.IProgram abstSyn = concSyn.toAbstrSyntax();
			System.out.println("Success!");
			System.out.println("\nAbstract syntax tree:");
			System.out.println(abstSyn.toString(""));
			System.out.println("Context check:");
			abstSyn.check();
			System.out.println("Success!");
			System.out.println("\nCode generation:");
			abstSyn.code(0);
			System.out.println("Success!");

			System.out.println("\nExecuting:");
			vm.execute();
		} catch (IOException | LexerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
