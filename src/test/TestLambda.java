package test;

import java.util.LinkedList;

import expression.*;
import statement.*;
import value.*;
import main.*;

public class TestLambda {

	public static void main(String[] args) {

		// array($array, 3);
		// $array[0] = 1;
		// $array[1] = 2;
		// $array[-1] = 3;
		// map(lambda($x) { return $x + 1; }, $array);
		// say($array[0]);

		Identifier _i = new Identifier();
		_i.set("$x");
		ASTNode u = new ASTNode(_i, null, null, null);
		ASTNode v = new ASTNode(new Constant(new IntValue(1)), null, null, null);
		ASTNode w = new ASTNode(new Addition(), null, u, v);
		u.setParent(w);
		v.setParent(w);
		LinkedList<Identifier> ids = new LinkedList<Identifier>();
		ids.add(_i);
		ASTNode x = new ASTNode(new Return(w), null, null, null);
		Lambda L = new Lambda(x, ids);
		ASTNode a = new ASTNode(L, null, null, null);
		Identifier _a = new Identifier();
		_a.set("$array");
		ASTNode b = new ASTNode(_a, null, null, null);
		ASTNode c = new ASTNode(new Map(), null, a, b);
		a.setParent(c);
		b.setParent(c);
		ASTNode d = new ASTNode(new ArrayElement(_a, 0), null, null, null);
		ASTNode e = new ASTNode(new Say(), null, d, null);
		d.setParent(e);
		ASTNode f = new ASTNode(new Sequence(), null, c, e);
		c.setParent(f);
		e.setParent(f);
		ASTNode g = new ASTNode(new ArrayElement(_a, 2), null, null, null);
		ASTNode h = new ASTNode(new Constant(new IntValue(3)), null, null, null);
		ASTNode i = new ASTNode(new Assignation(), null, g, h);
		g.setParent(i);
		h.setParent(i);
		ASTNode m = new ASTNode(new Sequence(), null, i, f);
		i.setParent(m);
		f.setParent(m);
		ASTNode j = new ASTNode(new ArrayElement(_a, 1), null, null, null);
		ASTNode k = new ASTNode(new Constant(new IntValue(2)), null, null, null);
		ASTNode l = new ASTNode(new Assignation(), null, j, k);
		j.setParent(l);
		k.setParent(l);
		ASTNode n = new ASTNode(new Sequence(), null, l, m);
		l.setParent(n);
		m.setParent(n);
		ASTNode o = new ASTNode(new ArrayElement(_a, 0), null, null, null);
		ASTNode p = new ASTNode(new Constant(new IntValue(1)), null, null, null);
		ASTNode q = new ASTNode(new Assignation(), null, o, p);
		o.setParent(q);
		p.setParent(q);
		ASTNode r = new ASTNode(new Sequence(), null, q, n);
		q.setParent(r);
		n.setParent(r);
		ASTNode s = new ASTNode(new ArrayDeclaration(_a, new Array(3)), null, null, null);
		ASTNode t = new ASTNode(new Sequence(), null, s, r);
		s.setParent(t);
		r.setParent(t);
		new Interpreter(t, null);

	}

}
