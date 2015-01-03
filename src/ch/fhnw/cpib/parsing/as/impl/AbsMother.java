package ch.fhnw.cpib.parsing.as.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.as.IAbsMother;

public class AbsMother implements IAbsMother {

	private IToken ident;
	private IAbsParam params;
	private IAbsInvariant invariant;
	private IAbsMother cpsDecl;
	private IAbsPrecondition precondition;
	private IAbsPostcondition postcondition;
	private IAbsCpsCmd cpsCmd;

	public AbsMother(IAbsMotherCopy prog, IAbsMother cpsDecl,
			IAbsPrecondition precondition, IAbsCpsCmd cpsCmd,
			IAbsPostcondition postcondition) {
		this.ident = prog.getIdent();
		this.params = prog.getParams();
		this.invariant = prog.getInvariant();
		this.precondition = precondition;
		this.cpsDecl = cpsDecl;
		this.postcondition = postcondition;
		this.cpsCmd = cpsCmd;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<Program>\n" + ident.toString(indent + '\t')
				+ params.toString(indent + '\t') + invariant.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ precondition.toString(indent + '\t') + cpsCmd.toString(indent + '\t')
				+ postcondition.toString(indent + '\t') + indent + "</Program>\n";
	}

}
