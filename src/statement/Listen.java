package statement;

import expression.Identifier;

public class Listen extends Statement {

	private Identifier id;

	public Listen(Identifier id) {
		this.id = id;
	}

	public Identifier getId() {
		return id;
	}

}
