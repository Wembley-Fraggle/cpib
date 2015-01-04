package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CmdWhile implements ICmd {
	private final IExpr expr;
	private final ICmd cmd;
	private final ICmd dbcInvCmd;
	
	public CmdWhile(final IExpr expr, 
	        final ICmd cmd, 
	        final ICmd dbcInvCmd) {
		this.expr = expr;
		this.cmd = cmd;
		this.dbcInvCmd = dbcInvCmd;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdWhile>\n"
				+ expr.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ indent
				+ "</CmdWhile>\n";
	}
	
	@Override
	public int getLine() {
	    return expr.getLine();
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        if (!expr.checkR().isType("BOOL")) {
            throw new ContextError(
                    "WHILE condition must be a boolean! ",
                     expr.getLine());
        }
        
        cmd.check(true);
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1=dbcInvCmd.code(loc);
        int loc2=expr.code(loc1);
        int loc3=loc2+1;
        int loc4=cmd.code(loc3);
        int loc5=loc4+1;
        IMLCompiler.getVM().CondJump(loc2,loc5);
        IMLCompiler.getVM().UncondJump(loc4,loc);
        return loc5;
    }
}
