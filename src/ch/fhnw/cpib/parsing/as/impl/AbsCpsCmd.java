package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsCmd;
import ch.fhnw.cpib.parsing.as.IAbsMother.IAbsCpsCmd;

public class AbsCpsCmd implements IAbsCpsCmd {

    private IAbsCmd cmd;
    private IAbsCpsCmd absSyn;
    
    public AbsCpsCmd(IAbsCmd cmd) {
        this.cmd = cmd;
    }
    
    public AbsCpsCmd(IAbsCpsCmd cmd, IAbsCpsCmd cpsCmd) {
        this.cmd = cmd;
        this.absSyn = absSyn;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}
}
