package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Procedure;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsDecl;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IDecl;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public final class ProgDecl implements ICpsDecl {
	private final IToken ident;
	private final IParam param;
	private final IGlobImp globImp;
	private final ICpsDecl cpsDecl;
	private final ICmd cmd;
	
	public ProgDecl(final IToken ident, final IParam param,
			final IGlobImp globImp, final ICpsDecl cpsDecl, final ICmd cmd) {
		this.ident = ident;
		this.param = param;
		this.globImp = globImp;
		this.cpsDecl = cpsDecl;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ProcDecl>\n"
				+ ident.toString(indent + '\t')
				+ param.toString(indent + '\t')
				+ globImp.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</ProcDecl>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getStart().getCurrentLine();
	}

    @Override
    public void checkDeclaration() throws ContextError {
    }
    
    @Override
    public int getCount() {
        return 1;
    }

    
    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = loc;
        Routine routine = IMLCompiler.getRoutineTable().getRoutine(
                ident.getValue());
        IMLCompiler.setScope(routine.getScope());
        routine.setAddress(loc1);
        IMLCompiler.getVM().Enter(
                loc1++, 
                routine.getInOutCopyCount() + cpsDecl.getCount(), 
                0);
        loc1 = param.codeIn(
                loc1, 
                routine.getParamList().size(), 
                0);
        
        loc1 = cmd.code(loc1);
        
        loc1 = param.codeOut(loc1, 
               routine.getParamList().size(),
               0);
        
        IMLCompiler.getVM().Return(loc1++, 0);
                
        IMLCompiler.setScope(null);
        return loc1;
    }

    @Override
    public void check(int locals) throws ContextError, HeapTooSmallError {
        // TODO Auto-generated method stub
        
    }
}
