package statement;

import expression.Identifier;

public class Size extends Statement {

	private Identifier array;
	private Identifier var;

	public Size(Identifier array, Identifier var) {
		this.array = array;
		this.var = var;
	}

	public Identifier getArrayId() {
		return array;
	}
	public Identifier getVarId() {
		return var;
	}

}
