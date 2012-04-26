package expression;

import java.util.List;

import main.ASTNode;
import value.Value;

public class Lambda extends Expression {

	private ASTNode body;
	private List<Identifier> ids;
	private List<Value> args;

	public Lambda(ASTNode body, List<Identifier> ids) {
		this.body = body;
		this.ids = ids;
	}

	public List<Identifier> getArgs() {
		return ids;
	}

	public List<Value> getArgsValues() {
		return args;
	}

	public ASTNode getBody() {
		return body;
	}

	public void setArgs(List<Value> args) {
		this.args = args;
	}

}
