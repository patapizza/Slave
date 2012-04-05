package main;

import java.util.List;

import expression.Identifier;

public class Parameter {

	private List<Identifier> args;
	private ASTNode body;

	Parameter(List<Identifier> args, ASTNode body) {
		this.args = args;
		this.body = body;
	}

	public List<Identifier> getArgs() {
		return args;
	}

	public ASTNode getBody() {
		return body;
	}

}
