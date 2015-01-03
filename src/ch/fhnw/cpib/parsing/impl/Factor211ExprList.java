package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IExprList;
import ch.fhnw.cpib.parsing.IFactor211;
import ch.fhnw.cpib.parsing.as.IAbsExpr;

public class Factor211ExprList implements IFactor211 {

    private IExprList exprList;
    public Factor211ExprList(IExprList exprList) {
        this.exprList = exprList;
    }
		@Override
		public IAbsExpr toAbsSyn() {
			// TODO Auto-generated method stub
			return null;
		}

}
