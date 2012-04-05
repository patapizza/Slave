package test;

import main.Interpreter;
import main.ASTNode;
import value.IntValue;
import value.StringValue;
import expression.*;
import statement.*;

	public class TestDiv {

		public static void main(String[] args) {
			ASTNode root = new ASTNode(new Sequence(), null, null, null);
			ASTNode left = new ASTNode(new Assignation(), root, null, null);
			root.setLeft(left);
			Identifier id = new Identifier();
			id.set("$x");
			ASTNode leftleft = new ASTNode(id, left, null, null);
			ASTNode leftright = new ASTNode(new Division(), left, null, null);
			ASTNode right = new ASTNode(new Say(), root, null, null);
			
			ASTNode leftrightleft = new ASTNode(new Constant(new IntValue(45)), left, null, null);
			ASTNode leftrightright = new ASTNode(new Constant(new IntValue(2)), left, null, null);
			
			
			//String * Int
			//ASTNode leftrightleft = new ASTNode(new StringE(new StringValue("b")), left, null, null);
			//ASTNode leftrightright = new ASTNode(new StringE(new StringValue("nn")), left, null, null);
			
			leftright.setRight(leftrightright);
			leftright.setLeft(leftrightleft);
			
			
			root.setRight(right);
			left.setLeft(leftleft);
			left.setRight(leftright);
			ASTNode rightleft = new ASTNode(id, right, null, null);
			right.setLeft(rightleft);
			Interpreter interpreter = new Interpreter(root, null);
		}

	}
