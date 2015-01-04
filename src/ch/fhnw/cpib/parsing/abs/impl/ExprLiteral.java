package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.enums.Types;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ContextError;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprLiteral implements IExpr {
private final Literal literal;
	
	public ExprLiteral(final Literal literal) {
		this.literal = literal;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprLiteral>\n"
				+ literal.toString(indent + '\t')
				+ indent
				+ "</ExprLiteral>\n";
	}
	
	@Override
    public int getLine() {
        return literal.getLine();
    }

    @Override
    public Types checkR() throws ContextError {
        return literal.getType();
    }
    
    @Override
    public Types checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Found literal " 
                + literal.getLiteral() 
                + "in the left part of an assignement",
                literal.getLine());
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        IMLCompiler.getVM().IntLoad(loc, literal.getLiteral());
        return loc + 1;
    }
}
