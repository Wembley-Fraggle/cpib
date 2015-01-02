package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IGlobImp2;
import ch.fhnw.cpib.parsing.as.IAbsChangemode;

public class GlobImp2 implements IGlobImp2 {

    private IChangemode changemode;
    public GlobImp2(IChangemode changemode) {
        this.changemode = changemode;
    }
		@Override
		public IAbsChangemode toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}

}
