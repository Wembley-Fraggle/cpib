package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CmdOut implements ICmd {
	private final IExpr expr;
	private ILiteralVal.Type type;
	
	public CmdOut(final IExpr expr) {
		this.expr = expr;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdOut>\n"
				+ expr.toString(indent + '\t')
				+ indent
				+ "</CmdOut>\n";
	}
	
	@Override
	public int getLine() {
	    return expr.getLine();
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        type = expr.checkR();
        if (!(expr instanceof ExprStore)) {
            throw new ContextError(
                    "Output needs to be a store!",
                     expr.getLine());
        }
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = ((ExprStore) expr).code(loc);
        if (type == ILiteralVal.Type.BOOL) {
            IMLCompiler.getVM().BoolOutput(
                    loc1++, ((ExprStore) expr).getIdent());
        } else {
            IMLCompiler.getVM().IntOutput(
                    loc1++, ((ExprStore) expr).getIdent());
        }
        return loc1;
    }
}
