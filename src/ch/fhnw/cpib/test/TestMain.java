package ch.fhnw.cpib.test;

import ch.fhnw.cpib.errors.LexicalError;
import ch.fhnw.cpib.lex.Scanner;
import ch.fhnw.cpib.model.IToken.Base;
import ch.fhnw.cpib.model.ITokenList;

public class TestMain {

	public static void main(String[] args) {
		String cs1 = "Liebe Grossmutter!"
				+ "Zu Deinem 67-ten Geburtstag";
		String cs2 = "while x36 <=67 do		x := x-1			endwhile";
		try {
			ITokenList tl1 = Scanner.scan(cs1);
			Base token = null;
			System.out.print("[");
			while((token = tl1.nextToken()) != null){
				System.out.print(token + ",");
			}
			System.out.print("]");
			System.out.println("\n\n\n");
			ITokenList tl2 = Scanner.scan(cs2);
			token = null;
			System.out.print("[");
			while((token = tl2.nextToken()) != null){
				System.out.print(token + ",");
			}
			System.out.print("]");
		} catch (InternalError e) {
			e.printStackTrace();
		} catch (LexicalError e) {
			e.printStackTrace();
		}
		
		
	}

}
