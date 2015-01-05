package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.ILiteralVal;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprDyadic implements IExpr {
	private final IToken operator;
	private final IExpr expr1;
	private final IExpr expr2;
	private ContextError error;
	
	public ExprDyadic(final IToken operator, 
	        final IExpr expr1, 
	        final IExpr expr2) {
		this.operator = operator;
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprDyadic>\n"
				+ operator.toString(indent + '\t')
				+ expr1.toString(indent + '\t')
				+ expr2.toString(indent + '\t')
				+ indent
				+ "</ExprDyadic>\n";
	}
	
	@Override
	public int getLine() {
	    return operator.getStart().getCurrentLine();
	}
	
	@Override
	public ILiteralVal.Type checkR() throws ContextError {
	    if (error != null) {
	        throw error;
	    }
	    
	    ILiteralVal.Type type1 = expr1.checkR();
	    ILiteralVal.Type type2 = expr2.checkR();
	    
	    switch(operator.getType().getName()) {
	        case "PLUS":
	        case "MINUS":
	        case "TIMES":
	        case "DIV":
	        case "MOD":
	            if (type1 == ILiteralVal.Type.INT32
	                && type2 == ILiteralVal.Type.INT32) {
	                return type1;
	            } else {
	                throw new ContextError(
	                        "Type error in Operator "
	                        + operator.getType(),
	                        operator.getStart().getCurrentLine());
	            }
	        case "EQ":
	        case "NE":
	            if (type1 == ILiteralVal.Type.BOOL
	                && type2 == ILiteralVal.Type.BOOL) {
	                return type1;
	            }
	        case "GT":
	        case "LT":
	        case "GE":
	        case "LE":
	            if (type1 == ILiteralVal.Type.INT32
                    && type2 == ILiteralVal.Type.INT32) {
	                return ILiteralVal.Type.BOOL;
                } else {
                    throw new ContextError(
                            "Type error in Operator "
                            + operator.getType(),
                            operator.getStart().getCurrentLine());
                }
	        case "CAND":
	        case "COR":
	            if (type1 == ILiteralVal.Type.BOOL
                    && type2 == ILiteralVal.Type.BOOL) {
                    return type1;
                } else {
                    throw new ContextError(
                            "Type error in Operator "
                            + operator.getType(),
                            operator.getStart().getCurrentLine());
                }
	        default:
	            throw new RuntimeException();
	    }
	}

    @Override
    public ILiteralVal.Type checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Found operator " 
                + operator.getValue()
                + "in the left part of an assignement",
                operator.getStart().getCurrentLine());
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = expr1.code(loc);
        if (!operator.getType().isType("CAND") 
                && !operator.getType().isType("COR")) {
            loc1 = expr2.code(loc1);
            switch (operator.getType().getName()) {
                case "PLUS":
                    IMLCompiler.getVM().IntAdd(loc1);
                    break;
                case "MINUS":
                    IMLCompiler.getVM().IntSub(loc1);
                    break;
                case "TIMES":
                    IMLCompiler.getVM().IntMult(loc1);
                    break;
                case "DIV":
                    IMLCompiler.getVM().IntDiv(loc1);
                    break;
                case "MOD":
                    IMLCompiler.getVM().IntMod(loc1);
                    break;
                case "EQ":
                    IMLCompiler.getVM().IntEQ(loc1);
                    break;
                case "NE":
                    IMLCompiler.getVM().IntNE(loc1);
                    break;
                case "GT":
                    IMLCompiler.getVM().IntGT(loc1);
                    break;
                case "LT":
                    IMLCompiler.getVM().IntLT(loc1);
                    break;
                case "GE":
                    IMLCompiler.getVM().IntGE(loc1);
                    break;
                case "LE":
                    IMLCompiler.getVM().IntLE(loc1);
                    break;
                default:
                    throw new RuntimeException();
            }
            return loc1 + 1;
        } else if (operator.getType().isType("CAND")) {
            int loc2 = expr2.code(loc1 + 1);
            IMLCompiler.getVM().UncondJump(loc2++, loc2 + 1);
            IMLCompiler.getVM().CondJump(loc1, loc2);
            IMLCompiler.getVM().IntLoad(loc2++, 0);
            return loc2;
        } else {
            int loc2 = expr2.code(loc1 + 2);
            IMLCompiler.getVM().UncondJump(loc2++, loc2 + 1);
            IMLCompiler.getVM().CondJump(loc1, loc1 + 2);
            IMLCompiler.getVM().UncondJump(loc1 + 1, loc2);
            IMLCompiler.getVM().IntLoad(loc2++, 1);
            return loc2;
        }
    }

    public void setError(final ContextError contextError) {
        error = contextError;
    }
}
