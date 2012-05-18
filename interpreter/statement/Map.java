package statement;

import expression.Lambda;
import expression.Identifier;

public class Map extends Statement {

	private Lambda l;
	private Identifier i;

	public Map(Lambda l, Identifier i) {
		this.l = l;
		this.i = i;
	}

	public Lambda getLeft() {
		return l;
	}

	public Identifier getRight() {
		return i;
	}

}
