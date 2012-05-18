package statement;

import java.util.List;

import expression.Identifier;
import expression.FName;

public class Function extends Statement {

	private FName name;
	private List<Identifier> args;
	private Sequence body;

	public Function(FName name, List<Identifier> ids, Sequence s) {
		this.name = name;
		this.args = ids;
		this.body = s;
	}

	public FName getName() {
		return name;
	}

	public List<Identifier> getArgs() {
		return args;
	}

	public Sequence getBody() {
		return body;
	}

}
