package ch.fhnw.cpib.parsing.abs.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Parameter;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.context.Routine.RoutineTypes;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IExpr;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;

public final class ExprCall implements IExpr {
	private final IToken ident;
	private final IExprList exprList;
	private final IGlobInit globInit;
	
	public ExprCall(final IToken ident, 
	        final IExprList exprList, 
	        final IGlobInit globInit) {
		this.ident = ident;
		this.exprList = exprList;
		this.globInit = globInit;
	}
	
	@Override
	public String toString(final String indent) {
	    StringBuffer out = new StringBuffer();
	        out.append("<ExprCall>\n")
	           .append(ident.toString(indent + '\t'))
	           .append(exprList.toString(indent + '\t'));
	        if(globInit != null) {
	            out.append(globInit.toString(indent + '\t'));
	        }
	        out.append(indent)
	           .append("</ExprCall>\n");
		return out.toString();
	}
	
	@Override
	public int getLine() {
	    return ident.getStart().getCurrentLine();
	}

    @Override
    public ITerminal checkR() throws ContextError {
        ITerminal type = IMLCompiler.getRoutineTable().getType(
                ident.getValue());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getValue() + " not declared",
                    ident.getStart().getCurrentLine());
        } else if (type.isType("PROC")) {
            throw new ContextError(
                    "Procedure call found in an expression: "
                            + ident.getValue() + "",
                    ident.getStart().getCurrentLine());
        }
        
        if (globInit != null && globInit instanceof GlobInit) {
            throw new ContextError(
                    "GlobInitList is only allowed for procedure calls", 
                    globInit.getLine());
        }
        
        Routine routine =  IMLCompiler.getRoutineTable().getRoutine(
                ident.getValue());
        
        List<Parameter> paramList 
            = new ArrayList<Parameter>(routine.getParamList());
        
        Set<String> aliasList = new HashSet<String>();
        
        exprList.check(paramList, aliasList, false);
        
        for (ch.fhnw.cpib.context.GlobImp globImp 
                : routine.getGlobImpList()) {
            if (!IMLCompiler.getScope().getStoreTable().getStore(
                    globImp.getIdent()).isInitialized()) {
                throw new ContextError(
                        "Global import of function not initialized! Ident: "
                            + globImp.getIdent(), 
                        ident.getStart().getCurrentLine());
            }
            
            if (aliasList.contains(globImp.getIdent())) {
                throw new ContextError(
                        "Global import is already used as a parameter! Ident: "
                            + globImp.getIdent(), 
                        ident.getStart().getCurrentLine());
            }
        }
        
        return type;
    }

    @Override
    public ITerminal checkL(final boolean canInit) throws ContextError {
        ITerminal type = IMLCompiler.getRoutineTable().getType(
                ident.getValue());
        
        if (type == null) {
            throw new ContextError(
                    "Ident " + ident.getValue() + " not declared",
                    ident.getStart().getCurrentLine());
        } else if (type.isType("PROC")) {
            throw new ContextError(
                    "Function call "
                            + ident.getValue() 
                            + " found in left part of an assignement",
                    ident.getStart().getCurrentLine());
        }

        Routine routine =  IMLCompiler.getRoutineTable().getRoutine(
                ident.getValue());
        
        List<Parameter> paramList 
            = new ArrayList<Parameter>(routine.getParamList());
        
        Set<String> aliasList = new HashSet<String>();
        
        exprList.check(paramList, aliasList, canInit);
        
        if(globInit != null) {
            Set<String> globInits = globInit.check(new HashSet<String>());
        
            for (ch.fhnw.cpib.context.GlobImp globImp 
                    : routine.getGlobImpList()) {
                
                switch (globImp.getFlowMode().getMode()) {
                    case IN:
                    case INOUT:
                        if (!IMLCompiler.getScope().getStoreTable().getStore(
                                globImp.getIdent()).isInitialized()) {
                            throw new ContextError(
                                    "Global import of function not initialized!" 
                                        + " Ident: " + globImp.getIdent(), 
                                    ident.getStart().getCurrentLine());
                        }
                        break;
                    case OUT:
                        if (globInits.contains(globImp.getIdent())) {
                            IMLCompiler.getScope().getStoreTable().getStore(
                                    globImp.getIdent()).initialize();
                            globInits.remove(globImp.getIdent());
                        }
                        break;
                    default:
                        throw new RuntimeException();
                }
                
                if (aliasList.contains(globImp.getIdent())) {
                    throw new ContextError(
                            "Global import is already used as a parameter! Ident: "
                                + globImp.getIdent(), 
                            ident.getStart().getCurrentLine());
                }
            }
            
            if (globInits.size() > 0) {
                throw new ContextError(
                        "Global init is not importet! Ident: "
                            + globInits.iterator().next(), 
                        ident.getStart().getCurrentLine());
            }
        }
        
        return type;
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = loc;
        int size = 0;
        
        if (IMLCompiler.getRoutineTable().getRoutine(
                ident.getValue()).getRoutineType() 
                    == RoutineTypes.FUNCTION) {
            size = 1;
        }
        
        
        IMLCompiler.getVM().Alloc(loc1++, size);
        loc1 = exprList.code(loc1);
        IMLCompiler.getRoutineTable().getRoutine(
                ident.getValue()).addCall(loc1++);
        
        return loc1;
    }
}
