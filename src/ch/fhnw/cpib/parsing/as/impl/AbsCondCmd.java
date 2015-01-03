package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsCondCmd;

public class AbsCondCmd implements IAbsCondCmd{
    private IAbsExpr expr;
    private IAbsCpsCmd cmdBlock;
    private IAbsCpsCmd alt;
    public AbsCondCmd(IAbsExpr expr, IAbsCpsCmd cmdBlock, IAbsCpsCmd alt) {
        this.expr = expr;
        this.cmdBlock = cmdBlock;
        this.alt = alt;
    }
		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}
}
