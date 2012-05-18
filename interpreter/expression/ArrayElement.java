package expression;

public class ArrayElement extends Identifier {

	private Identifier id;
	private Expression e;
	private int index;

	public ArrayElement(Identifier id, Expression e) {
		this.id = id;
		this.e = e;
	}

	public Identifier getId() {
		return id;
	}

	public Expression getExpression() {
		return e;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int i) {
		this.index = i;
	}

}
