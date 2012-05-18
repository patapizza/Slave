package statement;

import expression.Expression;

public class If extends Statement {

	private Expression e;
	private Statement s1, s2;

	public If(Expression e, Statement s1, Statement s2) {
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
	}

	public Expression getLeft() {
		return e;
	}

	public Statement getMiddle() {
		return s1;
	}

	public Statement getRight() {
		return s2;
	}

}
