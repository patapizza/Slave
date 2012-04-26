package test;

import java.util.LinkedList;

import expression.*;
import statement.*;
import value.*;
import main.*;

public class TestArray {

	public static void main(String[] args) {

		// array($array, 10);
		// $array[8] = true;
		// say($array[8]);

		Identifier _i = new Identifier();
		_i.set("$array");
		ArrayElement _ae = new ArrayElement(_i, -2);
		ASTNode a = new ASTNode(_ae, null, null, null);
		ASTNode b = new ASTNode(new BooleanE(new BooleanValue(true)), null, null, null);
		ASTNode c = new ASTNode(new Assignation(), null, a, b);
		a.setParent(c);
		b.setParent(c);
		ASTNode d = new ASTNode(_ae, null, null, null);
		ASTNode e = new ASTNode(new Say(), null, d, null);
		d.setParent(e);
		ASTNode f = new ASTNode(new Sequence(), null, c, e);
		c.setParent(f);
		e.setParent(f);
		ASTNode g = new ASTNode(new ArrayDeclaration(_i, new Array(10)), null, null, null);
		ASTNode h = new ASTNode(new Sequence(), null, g, f);
		g.setParent(h);
		f.setParent(h);
		new Interpreter(h, null);

	}

}
