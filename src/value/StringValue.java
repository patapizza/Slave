package value;

public class StringValue extends Value {

	private String s;
	
	public StringValue(String s) {
		this.s = s;
	}

	public String stringValue() {
		return s;
	}

	public String toString() {
		return s;
	}

}


