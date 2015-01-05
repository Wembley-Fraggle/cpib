package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CmdIn implements ICmd {
	private final IExpr expr;
	private ILiteralVal.Type type;
	
	public CmdIn(final IExpr expr) {
		this.expr = expr;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdIn>\n"
				+ expr.toString(indent + '\t')
				+ indent
				+ "</CmdIn>\n";
	}
	
	@Override
	public int getLine() {
	    return expr.getLine();
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        type = expr.checkL(canInit);
        if (!(expr instanceof ExprStore)) {
            throw new ContextError(
                    "Input needs to be assigned to a store!",
                     expr.getLine());
        }
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = ((ExprStore) expr).codeRef(loc);
        if (type == ILiteralVal.Type.BOOL) {
            IMLCompiler.getVM().BoolInput(
                    loc1++, ((ExprStore) expr).getIdent());
        } else {
            IMLCompiler.getVM().IntInput(
                    loc1++, ((ExprStore) expr).getIdent());
        }
        return loc1;
    }
}
