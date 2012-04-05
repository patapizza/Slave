package statement;

import value.Array;
import expression.Identifier;

public class ArrayDeclaration extends Statement {

	private Array a;
	private Identifier i;

	public ArrayDeclaration(Identifier i, Array a) {
		this.i = i;
		this.a = a;
	}

	public Identifier getId() {
		return i;
	}

	public Array getArray() {
		return a;
	}

}
