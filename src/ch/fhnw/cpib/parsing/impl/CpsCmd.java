package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.ICCmd;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.ICpsCmd1;
import ch.fhnw.cpib.parsing.as.IAbsCpsCmd;
import ch.fhnw.cpib.parsing.as.impl.AbsCpsCmd;

public class CpsCmd implements ICpsCmd{
    private ICCmd cmd;
    private ICpsCmd1 cpsCmd1;
    
    public CpsCmd(ICCmd cmd, ICpsCmd1 cpsCmd1) {
        this.cmd = cmd;
        this.cpsCmd1 = cpsCmd1;
    }

    @Override
    public IAbsCpsCmd toAbsSyn() {
        return cpsCmd1.toAbsSyn( new AbsCpsCmd(cmd.toAbsSyn()));
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}
}
