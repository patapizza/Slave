package expression;

public class Comparator extends BinaryOp {

	private Expression left, right;

	public void setLeft(Expression e) {
		this.left = e;
	}

	public void setRight(Expression e) {
		this.right = e;
	}

}
