package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;


public class LiteralInt32 implements ILiteral {
    private IToken intVal;
    public LiteralInt32(IToken intVal) {
        this.intVal = intVal;
    }
		@Override
		public IExpr toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String toString(String indent) {
			return indent + "<LITERAL>" + intVal.getValue() + "</LITERAL>\n";
		}
}
