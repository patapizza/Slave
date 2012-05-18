package expression;

public class Not extends Expression {

	private Expression e;

	public Not(Expression e) {
		this.e = e;
	}

	public Expression getLeft() {
		return e;
	}

}
