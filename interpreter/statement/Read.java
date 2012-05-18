package statement;

import expression.Identifier;
import expression.StringE;

public class Read extends Statement {

	private Identifier id;
	private StringE s;

	public Read(StringE s, Identifier id) {
		this.id = id;
		this.s = s;
	}

	public StringE getLeft() {
		return s;
	}

	public Identifier getRight() {
		return id;
	}

}
