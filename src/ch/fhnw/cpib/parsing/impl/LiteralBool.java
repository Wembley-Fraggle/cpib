package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IBoolVal;
import ch.fhnw.cpib.parsing.ILiteral;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;


//TODO Take a IToken
public class LiteralBool implements ILiteral{
    
    private IBoolVal value;
    public LiteralBool(IBoolVal value) {
        this.value = value;
    }
		@Override
		public IExpr toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}
}
