package statement;

import expression.Expression;

public class Say extends Statement {

	private Expression e;

	public Say(Expression e) {
		this.e = e;
	}

	public Expression getLeft() {
		return e;
	}

}
