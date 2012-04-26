package statement;

import main.ASTNode;

public class Return extends Statement {

	private ASTNode n;

	public Return(ASTNode n) {
		this.n = n;
	}

	public ASTNode getExpression() {
		return n;
	}

}
