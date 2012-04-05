package test;

import java.util.LinkedList;

import expression.*;
import statement.*;
import value.*;
import main.*;

public class TestWhile {

	public static void main(String[] args) {

		// $i = 0;
		// while ($i < 15) {
		// 	say($i);
		// 	$i = $i + 1;
		// }
		// if ($i == 15)
		// 	say($i);

		Identifier _i = new Identifier();
		_i.set("$i");
		ASTNode a = new ASTNode(_i, null, null, null);
		ASTNode b = new ASTNode(new Constant(new IntValue(0)), null, null, null);
		ASTNode c = new ASTNode(new Assignation(), null, a, b);
		ASTNode d = new ASTNode(_i, null, null, null);
		ASTNode e = new ASTNode(new Constant(new IntValue(15)), null, null, null);
		ASTNode f = new ASTNode(new LessThan(), null, d, e);
		ASTNode g = new ASTNode(_i, null, null, null);
		ASTNode h = new ASTNode(new Say(), null, g, null);
		g.setParent(h);
		ASTNode i = new ASTNode(_i, null, null, null);
		ASTNode j = new ASTNode(_i, null, null, null);
		ASTNode k = new ASTNode(new Constant(new IntValue(1)), null, null, null);
		ASTNode l = new ASTNode(new Addition(), null, j, k);
		j.setParent(l);
		k.setParent(l);
		ASTNode m = new ASTNode(new Assignation(), null, i, l);
		i.setParent(m);
		l.setParent(m);
		ASTNode n = new ASTNode(new Sequence(), null, h, m);
		h.setParent(n);
		m.setParent(n);
		ASTNode o = new ASTNode(new While(), null, f, n);
		f.setParent(o);
		n.setParent(o);
		ASTNode p = new ASTNode(_i, null, null, null);
		ASTNode q = new ASTNode(new Constant(new IntValue(15)), null, null, null);
		ASTNode r = new ASTNode(new EqualsTo(), null, p, q);
		p.setParent(r);
		q.setParent(r);
		ASTNode s = new ASTNode(_i, null, null, null);
		ASTNode t = new ASTNode(new Say(), null, s, null);
		s.setParent(t);
		ASTNode u = new ASTNode(new If(), null, r, null);
		r.setParent(u);
		u.setMiddle(t);
		t.setParent(u);
		ASTNode v = new ASTNode(new Sequence(), null, o, u);
		o.setParent(v);
		u.setParent(v);
		ASTNode w = new ASTNode(new Sequence(), null, c, v);
		c.setParent(w);
		v.setParent(w);
		new Interpreter(w, null);

	}

}
