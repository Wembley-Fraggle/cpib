package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.IStoDecl1;

public class StoDecl1 implements IStoDecl1{
    IChangemode changemode;
    public StoDecl1(IChangemode changemode) {
        this.changemode = changemode;
    }
		@Override
		public String toString(String indent) {
			return indent
					+ "<StoDecl1>\n"
					+ changemode.toString(indent + '\t')
					+ indent
					+ "</StoDecl1>\n";
		}
}
