package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.context.Scope;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IProgram;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public final class Program implements IProgram {
	private final IToken ident;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	
	public Program(final IToken ident, final ICpsDecl cpsDecl, final ICmd cmd) {
		this.ident = ident;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Program>\n"
				+ ident.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</Program>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getStart().getCurrentLine();
	}

    @Override
    public void check() throws ContextError, HeapTooSmallError {
        cpsDecl.checkDeclaration();
        cpsDecl.check(-1);
        IMLCompiler.setScope(
                new Scope(IMLCompiler.getGlobalStoreTable().clone()));
        cmd.check(false);
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = cmd.code(loc);
        IMLCompiler.getVM().Stop(loc1);
        loc1 = cpsDecl.code(loc1 + 1);
        
        for (Routine routine 
                : IMLCompiler.getRoutineTable().getTable().values()) {
            routine.codeCalls();
        }
        
        return loc1;
    }
}
