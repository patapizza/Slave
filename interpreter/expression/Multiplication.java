package expression;

public class Multiplication extends BinaryOp {

	private Expression left, right;

	public void setLeft(Expression e) {
		this.left = e;
	}

	public void setRight(Expression e) {
		this.right = e;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

}
