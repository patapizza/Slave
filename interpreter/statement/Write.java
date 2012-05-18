package statement;

import expression.Identifier;

public class Write extends Statement {

	private Identifier i;

	public Write(Identifier i) {
		this.i = i;
	}

	public Identifier getLeft() {
		return i;
	}

}
