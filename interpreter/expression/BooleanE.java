package expression;

import value.BooleanValue;

public class BooleanE extends Expression {

	private BooleanValue b;

	public BooleanE(BooleanValue b) {
		this.b = b;
	}

	public BooleanValue getValue() {
		return b;
	}

}

