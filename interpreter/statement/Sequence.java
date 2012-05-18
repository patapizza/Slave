package statement;

public class Sequence extends Statement {

	private Statement s1, s2;

	public Sequence(Statement s1, Statement s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public Statement getLeft() {
		return s1;
	}

	public Statement getRight() {
		return s2;
	}

}
