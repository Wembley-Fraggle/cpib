package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsAssiCmd;

public class AbsAssiCmd implements IAbsAssiCmd{
    private IAbsExpr left;
    private IAbsExpr right;
    
    public AbsAssiCmd(IAbsExpr left, IAbsExpr right) {
        this.left = left;
        this.right = right;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}
}
