package value;

public class IntValue extends Value
{
	private int i;
	
	public IntValue(int i) {
		this.i = i;
	}

	public int intValue() {
		return i;
	}

	public String toString() {
		return "" + i;
	}

}

