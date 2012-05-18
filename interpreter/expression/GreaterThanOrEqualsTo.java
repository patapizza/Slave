package expression;

public class GreaterThanOrEqualsTo extends Comparator {

	private Expression left, right;

	public void setLeft(Expression left) {
		this.left = left;
	}

	public void setRight(Expression right) {
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

}
