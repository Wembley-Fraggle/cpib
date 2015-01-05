package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.cpib.parsing.abs.impl.ExprLiteral;

public class LiteralBool implements ILiteral{
    
    private ILiteralVal value;
    public LiteralBool(ILiteralVal value) {
        this.value = value;
    }
		@Override
		public IExpr toAbsSyn() {
			return new ExprLiteral(value);
		}
		@Override
		public String toString(String indent) {
			return indent + "<LITERAL>" + value.getValue() + "</LITERAL>\n";
		}
}
