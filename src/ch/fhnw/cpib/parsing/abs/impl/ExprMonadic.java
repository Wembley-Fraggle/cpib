package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprMonadic implements IExpr {
	private final IToken operator;
	private final IExpr expr;

	public ExprMonadic(final IToken operator, final IExpr expr) {
		this.operator = operator;
		this.expr = expr;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<ExprMonadic>\n" + operator.toString(indent + '\t')
				+ expr.toString(indent + '\t') + indent + "</ExprMonadic>\n";
	}

	@Override
	public int getLine() {
		return operator.getStart().getCurrentLine();
	}

	@Override
	public ILiteralVal.Type checkR() throws ContextError {
	    ILiteralVal.Type type = expr.checkR();

		if (operator.getType().isType("PLUS") || operator.getType().isType("MINUS")) {
			switch (operator.getType().getName()) {
			case "PLUS":
			case "MINUS":
				if (type == ILiteralVal.Type.INT32) {
					return type;
				} else {
					throw new ContextError(
							"Type error in Operator " + operator.getType(), operator
									.getStart().getCurrentLine());
				}
			default:
				throw new RuntimeException();

			}
		} else if (operator.getType().isType("NOT")) {
			if (type == ILiteralVal.Type.BOOL) {
				return type;
			} else {
				throw new ContextError("Type error in Operator " + operator.getType(),
						operator.getStart().getCurrentLine());
			}
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public ILiteralVal.Type checkL(final boolean canInit) throws ContextError {
		throw new ContextError("Found operator " + operator.getType()
				+ "in the left part of an assignement", operator.getStart()
				.getCurrentLine());
	}

	@Override
	public int code(final int loc) throws CodeTooSmallError {
		int loc1 = expr.code(loc);
		if (operator.getType().isType("MINUS") || operator.getType().isType("PLUS")) {
			if (operator.getType().isType("MINUS")) {
				IMLCompiler.getVM().IntInv(loc1);
				return loc1 + 1;
			} else {
				return loc1;
			}
		} else if (operator.getType().isType("NOT")) {
			IMLCompiler.getVM().CondJump(loc1++, loc1 + 2);
			IMLCompiler.getVM().IntLoad(loc1++, 0);
			IMLCompiler.getVM().UncondJump(loc1++, loc1 + 1);
			IMLCompiler.getVM().IntLoad(loc1++, 1);
			return loc1;
		} else {
			throw new RuntimeException();
		}
	}
}
