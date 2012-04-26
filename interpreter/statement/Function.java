package statement;

import java.util.List;

import main.ASTNode;
import expression.Identifier;
import expression.FName;

public class Function extends Statement {

	private FName name;
	private List<Identifier> args;
	private ASTNode body;

	public Function(FName name, List<Identifier> args, ASTNode body) {
		this.name = name;
		this.args = args;
		this.body = body;
	}

	public FName getName() {
		return name;
	}

	public List<Identifier> getArgs() {
		return args;
	}

	public ASTNode getBody() {
		return body;
	}

}
