package statement;

import expression.Identifier;

public class Read extends Statement {

	private Identifier id;

	public Read(Identifier id) {
		this.id = id;
	}

	public Identifier getId() {
		return id;
	}

}
