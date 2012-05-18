package statement;

import main.ASTNode;

import expression.Expression;

public class Return extends Statement {

	private ASTNode n;

	public Return(Expression e) {
	}

	public Return(ASTNode n) {
		this.n = n;
	}

	public ASTNode getExpression() {
		return n;
	}

}
