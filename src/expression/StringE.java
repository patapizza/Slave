package expression;

import value.StringValue;

public class StringE extends Expression {

	private StringValue s;

	public StringE(StringValue s) {
		this.s = s;
	}

	public StringValue getValue() {
		return s;
	}

}

