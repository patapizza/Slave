package test;

import main.Interpreter;
import main.ASTNode;
import value.IntValue;
import value.StringValue;
import expression.*;
import statement.*;

public class TestRead {

	public static void main(String[] args) {
		ASTNode root = new ASTNode(new Sequence(), null, null, null);
		Identifier id = new Identifier();
		id.set("$x");
		ASTNode left = new ASTNode(new Read(id), root, null, null);
		root.setLeft(left);
		ASTNode leftleft = new ASTNode(new StringE(new StringValue("test")), left, null, null);
		left.setLeft(leftleft);
		ASTNode right = new ASTNode(new Say(), root, null, null);
		root.setRight(right);
		ASTNode rightleft = new ASTNode(id, right, null, null);
		right.setLeft(rightleft);
		
		Interpreter interpreter = new Interpreter(root, null);
		
	}

}
