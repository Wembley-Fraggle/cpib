package ch.fhnw.cpib.parsing.abs;

import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.context.Parameter;
import ch.fhnw.cpib.context.Routine;
import ch.fhnw.cpib.context.Store;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public interface IAbstSyn {
	public interface IProgram extends IAbstSyn {
	    void check() throws ContextError, HeapTooSmallError;
        int code(int loc) throws CodeTooSmallError;
	}
	
	public interface ICpsDecl extends IAbstSyn {
	    void checkDeclaration() throws ContextError, HeapTooSmallError;
	    void check(int locals) throws ContextError, HeapTooSmallError;
	    int code(int loc) throws CodeTooSmallError;
	    int getCount();
	}
	public interface IDecl extends IAbstSyn {
	    void checkDeclaration() throws ContextError, HeapTooSmallError;
	    int check(int locals) throws ContextError, HeapTooSmallError;
	    int code(int loc) throws CodeTooSmallError;
	}
	public interface IStoreDecl extends IDecl {
        ITerminal getType();
        String getIdent();
        Store check() throws ContextError;
    }
	
	public interface ICmd extends IAbstSyn {
	    void check(boolean canInit) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
	}
	public interface IParam extends IAbstSyn {
	    void check(Routine routine) throws ContextError;
	    void checkInit() throws ContextError;
	    int calculateAddress(int count, int locals);
	    int codeIn(int loc, int count, int locals) throws CodeTooSmallError;
	    int codeOut(int loc, int count, int locals) throws CodeTooSmallError;
	}
	public interface IGlobImp extends IAbstSyn {
	    void check(Routine routine) throws ContextError;
	    void checkInit() throws ContextError;
	}
	public interface IExpr extends IAbstSyn {
	    ITerminal checkR() throws ContextError;
	    ITerminal checkL(boolean canInit) throws ContextError;
        int code(int loc) throws CodeTooSmallError;
	}
	public interface IExprList extends IAbstSyn {
	    void check(
	            List<Parameter> paramList, 
	            Set<String> aliasList, 
	            boolean canInit)
	            throws ContextError;
	    int code(int loc) throws CodeTooSmallError;
	}
	public interface IGlobInit extends IAbstSyn {
	    Set<String> check(Set<String> initList)
	            throws ContextError;
	}
	
	String toString(String indent);
	int getLine();
	
	@SuppressWarnings("serial")
    public static final class ContextError extends Exception {
        public ContextError(final String errorMessage, final int line) {
            super(errorMessage + "\n\tat line:" + line);
            
        }
    }
}
