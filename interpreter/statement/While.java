package statement;

import expression.Expression;

public class While extends Statement {

	private Expression e;
	private Statement s;

	public While(Expression e, Statement s) {
		this.e = e;
		this.s = s;
	}

	public Expression getLeft() {
		return e;
	}

	public Statement getRight() {
		return s;
	}

}
