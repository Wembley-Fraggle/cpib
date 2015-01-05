package ch.fhnw.cpib.lexing;

public class EndMarker implements IEndMarker, ITerminal {

	public EndMarker() {
	}

	@Override
	public int canConsume(ILexerContext context) throws LexerException {
		return 0;
	}

	@Override
	public void consume(ILexerContext context) throws LexerException {
	}

	@Override
	public boolean isIgnore() {
		return true;
	}

	@Override
	public boolean isType(String name) {
		return getName().equals(name);
	}

	@Override
	public String getPattern() {
		return "";
	}

	@Override
	public String getName() {
		return "<$>";
	}

	@Override
	public int hashCode() {
		return 13 * getName().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() == this.getClass()) {
			return true;
		}
		return false;
	}

	public String toString() {
		return getName();
	}

	@Override
	public String toString(String indent) {
		return indent + "<EndMarker>" + getName() + "</EndMarker>\n";
	}
}
