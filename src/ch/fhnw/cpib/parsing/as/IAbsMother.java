package ch.fhnw.cpib.parsing.as;

import ch.fhnw.cpib.lexing.IToken;

public interface IAbsMother {
	
	public interface IAbsMotherCopy extends IAbsMother{
		public IToken getIdent();
		public IAbsParam getParams();
		public IAbsInvariant getInvariant();
	}

	public interface IAbsExpr extends IAbsMother {

	}

	public interface IAbsExprList extends IAbsMother {

	}

	public interface IAbsParam extends IAbsMother {

	}

	public interface IAbsInvariant extends IAbsMother {

	}

	public interface IAbsPrecondition extends IAbsMother {

	}

	public interface IAbsPostcondition extends IAbsMother {

	}

	public interface IAbsCmd extends IAbsMother {

	}

	public interface IAbsCpsCmd extends IAbsCmd {

	}
	
	public interface IAbsDecl extends IAbsMother {
		
	}

	String toString(String indent);

}
