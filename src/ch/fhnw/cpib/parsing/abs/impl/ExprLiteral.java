package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprLiteral implements IExpr {
    private final ILiteralVal literal;
	
	public ExprLiteral(final ILiteralVal literal) {
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
        return -1;
    }

    @Override
    public ILiteralVal.Type checkR() throws ContextError {
        return literal.getType();
    }
    
    @Override
    public ILiteralVal.Type checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Found literal " 
                + literal.getValue()
                + "in the left part of an assignement",getLine());
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        IMLCompiler.getVM().IntLoad(loc, literal.getValue());
        return loc + 1;
    }
}
