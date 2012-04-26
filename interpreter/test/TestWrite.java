package test;

import main.Interpreter;
import main.ASTNode;
import value.IntValue;
import value.StringValue;
import expression.*;
import statement.*;

	public class TestWrite {

		public static void main(String[] args) {
			ASTNode root = new ASTNode(new Sequence(), null, null, null);
			ASTNode left = new ASTNode(new Assignation(), root, null, null);
			root.setLeft(left);
			Identifier id = new Identifier();
			id.set("$x");
			ASTNode leftleft = new ASTNode(id, left, null, null);
			ASTNode right = new ASTNode(new Write(), root, null, null);
			ASTNode leftright = new ASTNode(new StringE(new StringValue("test")), left, null, null);
			ASTNode rightleft = new ASTNode(id, right, null, null);
			ASTNode rightright = new ASTNode(new StringE(new StringValue("boyeboye")), right, null, null);
			root.setRight(right);
			left.setLeft(leftleft);
			left.setRight(leftright);
			right.setLeft(rightleft);
			right.setRight(rightright);
			
			Interpreter interpreter = new Interpreter(root, null);
		}

	}
