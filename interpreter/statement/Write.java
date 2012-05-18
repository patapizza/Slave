package statement;

import expression.Identifier;
import expression.StringE;

public class Write extends Statement {

	private Identifier i;
	private StringE s;

	public Write(StringE s, Identifier i) {
		this.i = i;
		this.s = s;
	}

	public Identifier getRight() {
		return i;
	}

	public StringE getLeft() {
		return s;
	}

}
