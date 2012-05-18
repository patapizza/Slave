package statement;

import expression.Identifier;
import expression.Expression;

public class Assignation extends Statement {

	private Identifier i;
	private Expression e;

	public Assignation(Identifier i, Expression e) {
		this.i = i;
		this.e = e;
	}

	public Identifier getLeft() {
		return i;
	}

	public Expression getRight() {
		return e;
	}

}
