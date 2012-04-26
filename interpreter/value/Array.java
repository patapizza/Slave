package value;

public class Array extends Type {

	private int length;
	private Type[] elements;

	public Array(int length) {
		this.length = length;
		elements = new Type[length];
	}

	public boolean set(int index, Type value) {
		if (index >= length)
			return false;
		else if (index < 0 && Math.abs(index) <= length){
			elements[length + index] = value;
			return true;
		}
		else if (index < 0 && Math.abs(index) > length)
			return false;
		elements[index] = value;
		return true;
	}

	public Type get(int index) {
		if (index >= length)
			return new BooleanValue(false);
		else if (index < 0 && Math.abs(index) <= length)
			return elements[length + index];
		else if (index < 0 && Math.abs(index) > length)
			return new BooleanValue(false);
		return elements[index];
	}

	public int getLength() {
		return length;
	}

}
