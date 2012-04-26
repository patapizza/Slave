package test;

import java.util.LinkedList;

import expression.*;
import statement.*;
import value.*;
import main.*;

public class TestListen {

	public static void main(String[] args) {

		// $x;
		// listen($x);
		// say($x);

		ASTNode root = new ASTNode(new Sequence(), null, null, null);
		Identifier id = new Identifier();
		id.set("$x");
		ASTNode left = new ASTNode(new Declaration(id), root, null, null);
		ASTNode right = new ASTNode(new Sequence(), root, null, null);
		ASTNode rightleft = new ASTNode(new Listen(id), right, null, null);
		ASTNode rightright = new ASTNode(new Say(), right, null, null);
		ASTNode rightrightleft = new ASTNode(id, rightright, null, null);
		root.setLeft(left);
		root.setRight(right);
		right.setLeft(rightleft);
		right.setRight(rightright);
		rightright.setLeft(rightrightleft);
		new Interpreter(root, null);

	}

}
