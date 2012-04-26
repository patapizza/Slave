package test;

import java.util.LinkedList;

import expression.*;
import statement.*;
import value.*;
import main.*;

public class TestFunction {

	public static void main(String[] args) {

		// function f($r1) {
		//     $y = $r1 + 42;
		//     return 2 * $y;
		// }
		// $val = f(12);
		// say($val);

		Identifier _i = new Identifier();
		_i.set("$r1");
		ASTNode a = new ASTNode(_i, null, null, null);
		ASTNode b = new ASTNode(new Constant(new IntValue(42)), null, null, null);
		ASTNode c = new ASTNode(new Addition(), null, a, b);
		a.setParent(c);
		b.setParent(c);
		Identifier _j = new Identifier();
		_j.set("$y");
		ASTNode q = new ASTNode(_j, null, null, null);
		ASTNode d = new ASTNode(new Assignation(), null, q, c);
		q.setParent(d);
		c.setParent(d);
		ASTNode e = new ASTNode(new Constant(new IntValue(2)), null, null, null);
		ASTNode f = new ASTNode(_j, null, null, null);
		ASTNode g = new ASTNode(new Multiplication(), null, e, f);
		e.setParent(g);
		f.setParent(g);
		ASTNode h = new ASTNode(new Return(g), null, null, null);
		ASTNode i = new ASTNode(new Sequence(), null, d, h);
		d.setParent(i);
		h.setParent(i);
		Identifier arg1 = new Identifier();
		arg1.set("$r1");
		LinkedList<Identifier> list = new LinkedList<Identifier>();
		list.add(arg1);
		FName fname = new FName();
		fname.set("f");
		ASTNode j = new ASTNode(new Function(fname, list, i), null, null, null);
		Identifier _k = new Identifier();
		_k.set("$val");
		ASTNode l = new ASTNode(_k, null, null, null);
		ASTNode k = new ASTNode(new Constant(new IntValue(12)), null, null, null);
		LinkedList<ASTNode> list2 = new LinkedList<ASTNode>();
		list2.add(k);
		ASTNode m = new ASTNode(new Call(fname, list2), null, null, null);
		ASTNode r = new ASTNode(new Assignation(), null, l, m);
		l.setParent(r);
		m.setParent(r);
		ASTNode s = new ASTNode(_k, null, null, null);
		ASTNode n = new ASTNode(new Say(), null, s, null);
		s.setParent(n);
		ASTNode o = new ASTNode(new Sequence(), null, r, n);
		r.setParent(o);
		n.setParent(o);
		ASTNode p = new ASTNode(new Sequence(), null, j, o);
		j.setParent(p);
		o.setParent(p);
		new Interpreter(p, null);

	}

}
