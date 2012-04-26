package value;

public class BooleanValue extends Value {

	private boolean b;
	
	public BooleanValue(boolean b) {
		this.b = b;
	}

	public boolean booleanValue() {
		return b;
	}
	
	public String toString() {
		return "" + b;
	}

}
