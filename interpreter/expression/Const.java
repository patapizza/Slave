package expression;

import value.IntValue;
import value.Value;

public class Const extends Expression {
	private Value A;
	public Const(Value a) {
		A = a;
	}
	public Value eval() {
		return A;
	}

}

