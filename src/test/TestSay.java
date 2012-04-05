package test;

import java.util.LinkedList;

import expression.*;
import statement.*;
import value.*;
import main.*;

public class TestSay {

	public static void main(String[] args) {

		// $hello = "hello, world";
		// say($hello);

		ASTNode root = new ASTNode(new Sequence(), null, null, null);
		ASTNode left = new ASTNode(new Assignation(), root, null, null);
		root.setLeft(left);
		Identifier id = new Identifier();
		id.set("$hello");
		ASTNode leftleft = new ASTNode(id, left, null, null);
		ASTNode leftright = new ASTNode(new StringE(new StringValue("hello, world")), left, null, null);
		ASTNode right = new ASTNode(new Say(), root, null, null);
		root.setRight(right);
		left.setLeft(leftleft);
		left.setRight(leftright);
		ASTNode rightleft = new ASTNode(id, right, null, null);
		right.setLeft(rightleft);
		new Interpreter(root, null);

	}

}
