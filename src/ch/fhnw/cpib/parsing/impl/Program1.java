package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IInvariant;
import ch.fhnw.cpib.parsing.IProgram1;

public class Program1 implements IProgram1 {
	private IInvariant inv;

	public Program1(IInvariant inv) {
		this.inv = inv;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<invariant>" + inv + "</invariant>\n";
	}

}
