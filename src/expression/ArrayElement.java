package expression;

public class ArrayElement extends Expression {

	private Identifier id;
	private int index;

	public ArrayElement(Identifier id, int index) {
		this.id = id;
		this.index = index;
	}

	public Identifier getId() {
		return id;
	}

	public int getIndex() {
		return index;
	}

}
