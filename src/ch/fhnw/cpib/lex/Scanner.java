package ch.fhnw.cpib.lex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.fhnw.cpib.errors.LexicalError;
import ch.fhnw.cpib.model.IToken;
import ch.fhnw.cpib.model.ITokenList;
import ch.fhnw.cpib.model.Operators;
import ch.fhnw.cpib.model.Terminals;
import ch.fhnw.cpib.model.TokenList;

public class Scanner {

	private static final String PAT_WHITESPACE = "(blank | tab | nl)*";
	private static final String PAT_RELOPR = "(< | > | =)(=)";
	private static final String PAT_BECOMES = "[:=]";
	private static Map<String, Terminals> keywords = new HashMap<>();

	private static int state;
	private static long numAccu;
	private static StringBuffer lexAccu;
	private static int i;

	static {
		initKeywords();
	}

	private static void initKeywords() {
		keywords.put("while", Terminals.WHILE);
		keywords.put("do", Terminals.DO);
		keywords.put("endwhile", Terminals.ENDWHILE);
	}

	private static boolean isKeyword(String word) {
		return keywords.containsKey(word.toLowerCase());
	}

	public static ITokenList scan(CharSequence cs) throws LexicalError,
			InternalError {
		// precondition: last character (if it exists) is a newline
		assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';
		doh(cs.toString());
		ITokenList tokenList = new TokenList();
		state = 0;
		// for constructing the identifier
		lexAccu = null;
		// for constructing the literal value
		numAccu = 0L;

		for (i = 0; i < cs.length(); i++) {
			char c = cs.charAt(i);
			switch (state) {
			case 0:
				isCase0(c, tokenList);
				break;
			case 1:
				isCase1(c, tokenList);
				break;
			case 2:
				isCase2(c, tokenList);
				break;
			case 3:
				isCase3(c, tokenList);
				break;
			default:
				throw new InternalError("Default case in scanner.");
			}
		}
		if (lexAccu.length() != 0) {
			System.out.println("Input finished with Identifier");
			if (isKeyword(lexAccu.toString())) {
				tokenList.add(new IToken.Base(keywords.get(lexAccu.toString()
						.toLowerCase())));
			} else {
				tokenList.add(new IToken.Ident(lexAccu.toString()));
			}
		}
		assert state == 0;
		tokenList.add(new IToken.Base(Terminals.SENTINEL));
		return tokenList;
	}

	private static void isCase0(char c, ITokenList tokenList) {
		if (Character.isAlphabetic(c)) {
			lexAccu = new StringBuffer();
			state = 1;
			System.out.println("Case0, isAlphabetic: " + c);
			lexAccu.append(c);
		} else if (Character.isDigit(c)) {
			state = 2;
			int digit = Character.digit(c, 10);
			System.out.println("Case0, isDigit: " + digit);
			numAccu = digit;
		} else if (Character.isWhitespace(c)) {
			System.out.println("Case0, isWhitespace: " + c);
		} else {
			lexAccu = new StringBuffer();
			System.out.println("Case0, isOther: " + c);
			state = 3;
			i -= 1;
//			isSymbol(c, tokenList);
		}
	}

	private static void isSymbol(char c, ITokenList tokenList) {
		switch (c) {
		case '!':
			System.out.println("Case0, is ExclamationMark");
			state = 0;
			tokenList.add(new IToken.Base(Terminals.EXCLAMARK));
			break;
		case '-':
			System.out.println("Case0, is MINUS");
			state = 0;
			tokenList.add(new IToken.AddOpr(Operators.MINUS));
			break;
		}
	}

	private static void isCase1(char c, ITokenList tokenList) {
		if (Character.isAlphabetic(c)) {
			System.out.println("Case1, isAlphabetic: " + c);
			state = 1;
			lexAccu.append(c);
		} else if (Character.isDigit(c)) {
			System.out.println("Case1, isDigit: " + c);
			state = 1;
			lexAccu.append(c);
		} else {
			System.out.println("Case1, isOther: " + c);
			state = 0;
			i -= 1;
			if (isKeyword(lexAccu.toString())) {
				tokenList.add(new IToken.Base(keywords.get(lexAccu.toString()
						.toLowerCase())));
			} else {
				tokenList.add(new IToken.Ident(lexAccu.toString()));
			}
		}
	}

	private static void isCase2(char c, ITokenList tokenList) throws LexicalError {
		if (Character.isDigit(c)) {
			System.out.println("Case2, isDigit: " + c);
			state = 2;
			int digit = Character.digit(c, 10);
			numAccu = numAccu * 10 + digit;
			System.out.println("Case2, numAccu: " + numAccu);
			if (numAccu > Integer.MAX_VALUE) {
				throw new LexicalError("Integer literal too large!");
			}
		} else {
			System.out.println("Case2, isNotDigit: " + c);
			System.out.println("Case2, numAccu: " + numAccu);
			state = 0;
			// one back for next lexeme
			i = i - 1;
			tokenList.add(new IToken.Literal((int) numAccu));
		}
	}

	private static void isCase3(char c, ITokenList tokenList) {
		Pattern pattern = Pattern.compile(PAT_WHITESPACE);
		String s = lexAccu.append(c).toString();
		System.out.println(s);
		switch (s) {
		case "!":
			System.out.println("Case0, is ExclamationMark");
			state = 3;
			tokenList.add(new IToken.Base(Terminals.EXCLAMARK));
			break;
		case "-":
			System.out.println("Case0, is MINUS");
			state = 3;
			tokenList.add(new IToken.AddOpr(Operators.MINUS));
			break;
		case "<":
			break;
		case " ":
			state = 0;
			break;
		case "=":
			break;
		case ":":
			break;
		default:
			state = 0;
			i -= 1;
		}
	}
	
	private static void doh(String rep) {
		Pattern pattern = Pattern.compile("([-]?\\d+)*[/:]*([-]?\\d+)");
		pattern = Pattern.compile(PAT_BECOMES);
		Matcher matcher = pattern.matcher(rep.trim());
		if(!matcher.matches()){
			System.out.println("no matches");
			//error
		}
		System.out.println();
	}
}
