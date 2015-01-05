package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.ILiteralVal.Type;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprLiteral;


public class LiteralInt32 implements ILiteral {
    private IToken intVal;
    public LiteralInt32(IToken intVal) {
        this.intVal = intVal;
    }
		@Override
		public IExpr toAbsSyn() {
		    int val = Integer.parseInt(intVal.getValue());
			return new ExprLiteral(new LiteralVal(Type.INT32, val));
		}
		@Override
		public String toString(String indent) {
			return indent + "<LITERAL>" + intVal.getValue() + "</LITERAL>\n";
		}
}
