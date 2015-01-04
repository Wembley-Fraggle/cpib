package ch.fhnw.cpib.parsing.impl;

import ch.fhnw.cpib.parsing.IGlobImps1;
import ch.fhnw.cpib.parsing.IGlobImps2;

public class GlobImps1 implements IGlobImps1 {

	private IGlobImps2 globImps2;
	private IGlobImps1 globImps1;

	public GlobImps1(IGlobImps2 globImps2, IGlobImps1 globImps1) {
		this.globImps2 = globImps2;
		this.globImps1 = globImps1;
	}

	@Override
	public String toString(String indent) {
		return indent + "<GlobalImps1>\n" + globImps2.toString(indent + '\t')
				+ globImps1.toString(indent + '\t') + indent + "</GlobalImps1/>\n";
	}

}
