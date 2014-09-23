package ch.fhnw.cpib.model;

public interface IToken {

	static class Base {
		private final Terminals terminal;

		public Base(Terminals terminal) {
			this.terminal = terminal;
		}

		public Terminals getTerminal() {
			return terminal;
		}

		public String toString() {
			return terminal.toString();
		}
	}

	static class Ident extends Base {

		private final String ident;

		public Ident(String ident) {
			super(Terminals.IDENT);
			this.ident = ident;
		}

		public String getIdent() {
			return ident;
		}

		@Override
		public String toString() {
			return "(" + super.toString() + ",\"" + ident + "\")";
		}

	}

	static class Literal extends Base {

		private final int value;

		public Literal(int value) {
			super(Terminals.LITERAL);
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "(" + super.toString() + "," + value + ")";
		}

	}

	static class AddOpr extends Base {

		private final Operators opr;

		public AddOpr(Operators opr) {
			super(Terminals.ADDOPR);
			this.opr = opr;
		}

		public Operators getOpr() {
			return opr;
		}

		@Override
		public String toString() {
			return "(" + super.toString() + "," + opr + ")";
		}

	}

	static class RelOpr extends Base {

		private final Operators opr;

		public RelOpr(Operators opr) {
			super(Terminals.RELOPR);
			this.opr = opr;
		}

		public Operators getOpr() {
			return opr;
		}

		@Override
		public String toString() {
			return "(" + super.toString() + "," + opr + ")";
		}

	}

}
