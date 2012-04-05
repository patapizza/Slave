package expression;

import value.IntValue;

public class Constant extends Expression {

	private IntValue c;

	public Constant(IntValue c) {
		this.c = c;
	}

	public IntValue getValue() {
		return c;
	}

}

