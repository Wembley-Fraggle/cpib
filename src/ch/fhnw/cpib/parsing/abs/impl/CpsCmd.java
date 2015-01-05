package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.parsing.abs.IAbstSyn.ICpsCmd;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class CpsCmd implements ICpsCmd {
    
    private ICmd left;
    private ICmd right;
    
    public CpsCmd(ICmd left, ICpsCmd right) {
        this.left = left;
        this.right = right;
    }
    
	@Override
    public String toString(final String indent) {
		return indent 
		        + "<CpsCmd>\n"
                + left.toString(indent + '\t')
                + right.toString(indent + '\t')
                + indent
                + "</CpsCmd>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        left.check(canInit);
        right.check(canInit);        
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = left.code(loc);
        return right.code(loc1);
    }
}
