package main;
public class ASTNode {

	private Object value;
	private ASTNode parent;
	private ASTNode left;
	private ASTNode middle;
	private ASTNode right;

	public ASTNode(Object value, ASTNode parent, ASTNode left, ASTNode right) {
		this.value = value;
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.middle = null;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return left == null && right == null && middle == null;
	}

	public ASTNode getLeft() {
		return left;
	}

	public ASTNode getMiddle() {
		return middle;
	}

	public ASTNode getRight() {
		return right;
	}

	public Object getValue() {
		return value;
	}

	public void setLeft(ASTNode left) {
		this.left = left;
	}

	public void setMiddle(ASTNode middle) {
		this.middle = middle;
	}

	public void setRight(ASTNode right) {
		this.right = right;
	}

	public void setParent(ASTNode parent) {
		this.parent = parent;
	}

}
