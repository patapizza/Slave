package expression;

public abstract class BinaryOp extends Expression {

	public abstract void setLeft(Expression e); 

	public abstract void setRight(Expression e);

	public abstract Expression getLeft(); 

	public abstract Expression getRight(); 

}
