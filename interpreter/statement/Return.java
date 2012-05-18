package statement;

import expression.Expression;

public class Return extends Statement {

	private Expression e;

	public Return(Expression e) {
		this.e = e;
	}

	public Expression getExpression() {
		return e;
	}

}
