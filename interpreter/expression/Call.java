package expression;

import java.util.List;

public class Call extends Expression {

	private List<Expression> args;
	private FName name;

	public Call(FName name, List<Expression> args) {
		this.name = name;
		this.args = args;
	}


	public FName getName() {
		return name;
	}

	public List<Expression> getArgs() {
		return args;
	}

}
