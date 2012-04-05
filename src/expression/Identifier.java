package expression;

public class Identifier extends Expression {

	private String name;

	public Identifier() {
	}

	public boolean set(String s) {
		if (!s.matches("^\\$[a-z]+[a-zA-Z0-9]*$"))
			return false;
		name = s;
		return true;
	}

	public void bypass(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

}
