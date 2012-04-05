package test;
import main.Interpreter;
import main.ASTNode;
import value.Array;
import value.IntValue;
import value.StringValue;
import expression.*;
import statement.*;

public class TestSize {
	public static void main(String[] args) {
		// array($array, 10);
		// size($array, $val);
		// say($val);
	
		Identifier _i = new Identifier();
		_i.set("$array");
		Identifier val = new Identifier();
		val.set("$val");
		ASTNode size = new ASTNode(new Size(_i, val), null, null, null);
		ASTNode d = new ASTNode(val, null, null, null);
		ASTNode e = new ASTNode(new Say(), null, d, null);
		d.setParent(e);
		ASTNode f = new ASTNode(new Sequence(), null, size, e);
		size.setParent(f);
		e.setParent(f);
		ASTNode g = new ASTNode(new ArrayDeclaration(_i, new Array(10)), null, null, null);
		ASTNode h = new ASTNode(new Sequence(), null, g, f);
		g.setParent(h);
		f.setParent(h);
		new Interpreter(h, null);
	}
}
