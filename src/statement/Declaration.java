package statement;

import expression.Identifier;

public class Declaration extends Statement {

	private Identifier id;

	public Declaration(Identifier id) {
		this.id = id;
	}

	public Identifier getId() {
		return id;
	}

}
