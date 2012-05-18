package expression;

import java.util.List;

import value.Value;

import statement.Return;

public class Lambda extends Expression {

	private Return body;
	private List<Identifier> ids;
	private List<Value> args;

	public Lambda(Return r, List<Identifier> ids) {
		this.body = r;
		this.ids = ids;
	}

	public List<Identifier> getArgs() {
		return ids;
	}

	public List<Value> getArgsValues() {
		return args;
	}

	public Return getBody() {
		return body;
	}

	public void setArgs(List<Value> args) {
		this.args = args;
	}

}
