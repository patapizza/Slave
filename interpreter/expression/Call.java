package expression;

import java.util.List;

import main.ASTNode;

public class Call extends Expression {

	private List<ASTNode> args;
	private FName name;

	/*public Call(FName name, List<Expression> args) {
	}*/
	public Call(FName name) {
	}
	public void setArgs(List<Expression> args) {
	}

	public Call(FName name, List<ASTNode> args) {
		this.name = name;
		this.args = args;
	}


	public FName getName() {
		return name;
	}

	public List<ASTNode> getArgs() {
		return args;
	}

}
