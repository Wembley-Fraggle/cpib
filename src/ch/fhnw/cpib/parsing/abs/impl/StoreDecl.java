package ch.fhnw.cpib.parsing.abs.impl;

import ch.fhnw.cpib.IMLCompiler;
import ch.fhnw.cpib.context.Store;
import ch.fhnw.cpib.lexing.ITerminal;
import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.IChangemode;
import ch.fhnw.cpib.parsing.abs.IAbstSyn.IStoreDecl;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.CodeTooSmallError;
import ch.fhnw.lederer.virtualmachine.IVirtualMachine.HeapTooSmallError;

public final class StoreDecl implements IStoreDecl {
	private final IChangemode changeMode;
	private final IToken ident;
	private final ITerminal type;

	public String getIdent() {
		return ident.getValue();
	}

	public StoreDecl(final IChangemode changeMode, final IToken ident,
			final ITerminal type) {
		this.changeMode = changeMode;
		this.ident = ident;
		this.type = type;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<StoreDecl>\n" + changeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t') + type.toString(indent + '\t') + indent
				+ "</StoreDecl>\n";
	}

	@Override
	public int getLine() {
		return ident.getStart().getCurrentLine();
	}

	private Store getStore() {
        return new Store(
                ident.getValue(),
                type,
                changeMode.getMode().getType().isType("CONST"));
    }

	@Override
	public ITerminal getType() {
		return type;
	}

	@Override
	public int check(final int locals) throws ContextError, HeapTooSmallError {
		if (locals < 0) {
			return -1;
		} else {
			Store store = check();
			store.setAddress(2 + locals + 1);
			store.setRelative(true);
			store.setReference(false);
			return locals + 1;
		}

	}

	@Override
	public void checkDeclaration() throws ContextError, HeapTooSmallError {
		Store store = getStore();
		if (!IMLCompiler.getGlobalStoreTable().addStore(store)) {
			throw new ContextError("Store already declared: " + ident.getValue(),
					ident.getStart().getCurrentLine());
		}
		if (type.isType("BOOL")) {
			store.setAddress(IMLCompiler.getVM().BoolInitHeapCell());
			store.setRelative(false);
		} else {
			store.setAddress(IMLCompiler.getVM().IntInitHeapCell());
			store.setRelative(false);
		}
	}

	@Override
	public Store check() throws ContextError {
		Store store = getStore();

		if (!IMLCompiler.getScope().getStoreTable().addStore(store)) {
			throw new ContextError("Ident already declared: " + ident.getValue(),
					ident.getStart().getCurrentLine());
		}

		return store;
	}

	@Override
	public int code(final int loc) throws CodeTooSmallError {
		return loc;
	}
}
