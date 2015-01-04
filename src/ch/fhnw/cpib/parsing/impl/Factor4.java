package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IConcExpr;
import ch.fhnw.cpib.parsing.IFactor4;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;

@Deprecated()
// TODO Remove this
public class Factor4 implements IFactor4 {
    private IToken old;
    private IToken lParent;
    private IConcExpr expr;
    private IToken rParent;
    
    public Factor4(IToken old, IToken lParent, IConcExpr expr, IToken rParent) {
        this.old = old;
        this.lParent = lParent;
        this.expr = expr;
        this.rParent = rParent;
    }

    @Override
    public IExpr toAbsSyn() {
        // TODO Auto-generated method stub
        return null;
    }

		@Override
		public String toString(String indent) {
			// TODO Auto-generated method stub
			return null;
		}

}
