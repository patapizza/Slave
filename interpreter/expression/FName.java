package expression;

import java.util.List;

public class FName extends Expression {

	private String name;

	public FName() {
	}

	public boolean set(String name) {
		if (!name.matches("^[a-z]+[a-zA-Z0-9]*$"))
			return false;
		this.name = name;
		return true;
	}

	public String getName() {
		return name;
	}

}
