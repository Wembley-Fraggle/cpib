package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprLiteral implements IExpr {
    private final IToken literal;
	
	public ExprLiteral(final IToken literal) {
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
        return literal.getStart().getCurrentLine();
    }

    @Override
    public ITerminal checkR() throws ContextError {
        return literal.getType();
    }
    
    @Override
    public ITerminal checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Found literal " 
                + literal.getValue()
                + "in the left part of an assignement",getLine());
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        // FIXME Can be either a int or bool
        IMLCompiler.getVM().IntLoad(loc, literal.getLiteral());
        return loc + 1;
    }
}
