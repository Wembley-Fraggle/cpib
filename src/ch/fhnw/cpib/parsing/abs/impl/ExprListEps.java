package ch.fhnw.cpib.parsing.abs.impl;

import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.context.Parameter;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExprList;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprListEps implements IExprList {
	@Override
	public String toString(final String indent) {
		return indent + "<ExprListEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(
            final List<Parameter> paramList, 
            final Set<String> aliasList,
            final boolean canInit) throws ContextError {

        if (paramList.size() > 0) {
            throw new ContextError(
                    "Missing parameter!", 
                    -1);
        }
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        return loc;
    }
}
