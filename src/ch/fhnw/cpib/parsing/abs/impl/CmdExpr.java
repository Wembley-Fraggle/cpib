package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CmdExpr implements ICmd {
	private final IExpr targetExpr;
	private final IExpr sourceExpr;
	
	public CmdExpr(final IExpr targetExpr, 
	        final IExpr sourceExpr) {
		this.targetExpr = targetExpr;
		this.sourceExpr = sourceExpr;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdExpr>\n"
				+ targetExpr.toString(indent + '\t')
				+ sourceExpr.toString(indent + '\t')
				+ indent
				+ "</CmdExpr>\n";
	}
	
	@Override
	public int getLine() {
	    return targetExpr.getLine();
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        ITerminal typeL = targetExpr.checkL(canInit);
        if (typeL.isType("PROC")) {
            if (!(sourceExpr instanceof ExprEps)) {
                throw new ContextError(
                        "Procedure call can not be in an assignement!: "
                        , targetExpr.getLine());
            }
        } else {
            ITerminal typeR = sourceExpr.checkR();
            if (typeR != typeL) {
                throw new ContextError(
                        "Types in assignemt don't match!: "
                        , targetExpr.getLine());
            }
        }
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = sourceExpr.code(loc);
        int loc2;
        if (!(targetExpr instanceof ExprStore)) {
            loc2 = targetExpr.code(loc1);
        } else {
            loc2 = ((ExprStore) targetExpr).codeRef(loc1);
            IMLCompiler.getVM().Store(loc1);
        }
        return loc2;
    }
}
