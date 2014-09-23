package ch.fhnw.cpib.model;

import java.util.LinkedList;
import java.util.List;

import ch.fhnw.cpib.model.IToken.Base;

public class TokenList implements ITokenList {
	
	private List<Base> tokens = new LinkedList<>();
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
	}

	@Override
	public Base nextToken() {
		if(tokens.isEmpty()){
			return null;
		}
		return tokens.remove(0);
	}

	@Override
	public void add(IToken.Base token) {
		tokens.add(token);
	}

}
