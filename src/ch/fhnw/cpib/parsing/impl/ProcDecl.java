package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ICpsCmd;
import ch.fhnw.cpib.parsing.IParamList;
import ch.fhnw.cpib.parsing.IProcDecl;
import ch.fhnw.cpib.parsing.IProcDecl1;
import ch.fhnw.cpib.parsing.IProcDecl2;
import ch.fhnw.cpib.parsing.IProcDecl3;
import ch.fhnw.cpib.parsing.IProcDecl4;

public class ProcDecl implements IProcDecl {

    private IToken proc;
    private IToken ident;
    private IParamList paramList;
    private IProcDecl1 procDecl1;
    private IProcDecl2 procDecl2;
    private IProcDecl3 procDecl3;
    private IToken doToken;
    private ICpsCmd cpsCmd;
    IProcDecl4 procDecl4;
    private IToken endProc;

    public ProcDecl(IToken proc, IToken ident, IParamList paramList,
            IProcDecl1 procDecl1, IProcDecl2 procDecl2, IProcDecl3 procDecl3,
            IToken doToken, ICpsCmd cpsCmd, IProcDecl4 procDecl4, IToken endProc) {
        this.proc = proc;
        this.ident = ident;
        this.paramList = paramList;
        this.procDecl1 = procDecl1;
        this.procDecl2 = procDecl2;
        this.procDecl3 = procDecl3;
        this.doToken = doToken;
        this.cpsCmd = cpsCmd;
        this.procDecl4 = procDecl4;
        this.endProc = endProc;
    }

    @Override
  	public String toString(final String indent) {
  		return indent
  				+ "<ProcDecl>\n"
  				+ ident.toString(indent + '\t')
  				+ paramList.toString(indent + '\t')
  				+ procDecl1.toString(indent + '\t')
  				+ procDecl2.toString(indent + '\t')
  				+ procDecl3.toString(indent + '\t')
  				+ cpsCmd.toString(indent + '\t')
  				+ procDecl4.toString(indent + '\t')
  				+ indent
  				+ "</ProcDecl>\n";
  	}
}
