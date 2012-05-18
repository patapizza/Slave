package main;

import java.util.List;

import expression.Identifier;
import statement.Sequence;

public class Parameter {

	private List<Identifier> args;
	private Sequence body;

	Parameter(List<Identifier> args, Sequence body) {
		this.args = args;
		this.body = body;
	}

	public List<Identifier> getArgs() {
		return args;
	}

	public Sequence getBody() {
		return body;
	}

}
