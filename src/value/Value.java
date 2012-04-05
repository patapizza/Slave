package value;

public abstract class Value extends Type {

	public abstract String toString();

	public static Value add(Value v1, Value v2) {
		if(v1 instanceof StringValue && v2 instanceof StringValue)
			return new StringValue(((StringValue) v1).stringValue() + ((StringValue) v2).stringValue());
		if (v1 instanceof IntValue && v2 instanceof IntValue)
			return new IntValue(((IntValue) v1).intValue() + ((IntValue) v2).intValue());
		return new BooleanValue(false);
	}

	public static Value subtract(Value v1, Value v2) {
		if (!(v1 instanceof IntValue) || !(v2 instanceof IntValue))
			return new BooleanValue(false);
		return new IntValue(((IntValue) v1).intValue() - ((IntValue) v2).intValue());
	}

	public static Value divide(Value v1, Value v2) {
		if (!(v1 instanceof IntValue) || !(v2 instanceof IntValue))
			return new BooleanValue(false);
		return new IntValue(((IntValue) v1).intValue() / ((IntValue) v2).intValue());
	}

	public static Value multiply(Value v1, Value v2) {
		if (v1 instanceof IntValue && v2 instanceof IntValue)
			return new IntValue(((IntValue) v1).intValue() * ((IntValue) v2).intValue());
		if ((v1 instanceof StringValue && v2 instanceof IntValue)) {
			int i = 0;
			String s = "";
			while (i < ((IntValue) v2).intValue()){
				s += ((StringValue) v1).stringValue();
				i++;
			}
			return new StringValue(s);
		}
		return new BooleanValue(false);
	}

	public static Value modulo(Value v1, Value v2) {
		if (!(v1 instanceof IntValue) || !(v2 instanceof IntValue))
			return new BooleanValue(false);
		return new IntValue(((IntValue) v1).intValue() % ((IntValue) v2).intValue());
	}

	// greater than
	public static Value greaterThan(Value v1, Value v2) {
		if (!(v1 instanceof IntValue) || !(v2 instanceof IntValue))
			return new BooleanValue(false);
		return new BooleanValue(((IntValue) v1).intValue() > ((IntValue) v2).intValue());
	}
	// greater than or equals to
	public static Value greaterThanOrEqualsTo(Value v1, Value v2) {
		if (!(v1 instanceof IntValue) || !(v2 instanceof IntValue))
			return new BooleanValue(false);
		return new BooleanValue(((IntValue) v1).intValue() >= ((IntValue) v2).intValue());
	}

	// lower than
	public static Value lessThan(Value v1, Value v2) {
		if (!(v1 instanceof IntValue) || !(v2 instanceof IntValue))
			return new BooleanValue(false);
		return new BooleanValue(((IntValue) v1).intValue() < ((IntValue) v2).intValue());
	}
	// lower than or equals to
	public static Value lessThanOrEqualsTo(Value v1, Value v2) {
		if (!(v1 instanceof IntValue) || !(v2 instanceof IntValue))
			return new BooleanValue(false);
		return new BooleanValue(((IntValue) v1).intValue() <= ((IntValue) v2).intValue());
	}
	// equals to
	public static Value equalsTo(Value v1, Value v2) {
		if (v1 instanceof BooleanValue && v2 instanceof BooleanValue)
			return new BooleanValue(((BooleanValue) v1).booleanValue() == ((BooleanValue) v2).booleanValue());
		if (v1 instanceof IntValue && v2 instanceof IntValue)
			return new BooleanValue(((IntValue) v1).intValue() == ((IntValue) v2).intValue());
		return new BooleanValue(false);
	}

	// and
	public static Value and(Value v1, Value v2) {
		if (v1 instanceof BooleanValue && v2 instanceof BooleanValue)
			return new BooleanValue(((BooleanValue) v1).booleanValue() && ((BooleanValue) v2).booleanValue());
		return new BooleanValue(false);
	}

	// or
	public static Value or(Value v1, Value v2) {
		if(v1 instanceof BooleanValue && v2 instanceof BooleanValue)
			return new BooleanValue(((BooleanValue) v1).booleanValue() || ((BooleanValue) v2).booleanValue());
		return new BooleanValue(false);
	}

	// not
	public static Value not(Value v1) {
		if (v1 instanceof BooleanValue)
			return new BooleanValue(!((BooleanValue) v1).booleanValue());
		return new BooleanValue(false);
	}
	// minus
	public static Value minus(Value v1) {
		if (v1 instanceof IntValue)
			return new IntValue(- ((IntValue) v1).intValue());
		return new BooleanValue(false);
	}

	// different
	public static Value different(Value v1, Value v2) {
		if (v1 instanceof BooleanValue && v2 instanceof BooleanValue)
			return new BooleanValue(((BooleanValue) v1).booleanValue() != ((BooleanValue) v2).booleanValue());
		if (v1 instanceof IntValue && v2 instanceof IntValue)
			return new BooleanValue(((IntValue) v1).intValue() != ((IntValue) v2).intValue());
		return new BooleanValue(false);
	}

}
