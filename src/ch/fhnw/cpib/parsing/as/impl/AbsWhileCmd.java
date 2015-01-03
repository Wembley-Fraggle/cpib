package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsWhileCmd;

public class AbsWhileCmd implements IAbsWhileCmd {

    private IAbsExpr condition;
    private IAbsInvariant invariant;
    private IAbsCpsCmd blockCmd;
    
    public AbsWhileCmd(IAbsExpr condition, IAbsInvariant invariant,
            IAbsCpsCmd blockCmd) {
        this.condition = condition;
        this.invariant = invariant;
        this.blockCmd = blockCmd;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}
}
