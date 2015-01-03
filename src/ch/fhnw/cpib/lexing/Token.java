package ch.fhnw.cpib.lexing;

public class Token implements IToken {

	private ITerminal type;
	private IPosition start;
	private String value;

	public Token(ITerminal type, String value) {
		this.type = type;
		this.value = value;
	}

	public Token(ITerminal type, IPosition start, String value) {
		this.type = type;
		this.start = start;
		this.value = value;
	}

	@Override
	public IPosition getStart() {
		return start;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append("\"").append(value).append("\" : ");
		builder.append(type.getName()).append(" ");
		if (start != null) {
			builder.append(start);
		}
		builder.append(")");

		return builder.toString();
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public ITerminal getType() {
		return type;
	}

	@Override
	public String toString(String indent) {
		// TODO Auto-generated method stub
		return indent + "<Token>" + getValue() + "</Token>\n";
	}
}
