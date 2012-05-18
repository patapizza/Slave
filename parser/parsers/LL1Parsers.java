package parsers;

import lexer.ILexer;
import lexer.Lexer;
import lexer.IToken;
import slip.grammars.Grammar;
import slip.trees.TreeNode;
import gtools.GTools;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Stack;

public class LL1Parsers {

	private static int _nb_terminals;
	private static int[][][] _parse_table;
	private static GTools _gt;

	public static boolean isOk(ILexer lex, GTools gt) throws Exception {
		try {
			parse(lex, gt);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private static int[] trimFirst(int[] a) {
		int[] r = new int[a.length - 1];
		for (int i = 1 ; i < a.length ; i++)
			r[i - 1] = a[i];
		return r;
	}

	private static int[] append(int[] a, int[] b) {
		int[] r = new int[a.length + b.length];
		for (int i = 0 ; i < a.length ; i++)
			r[i] = a[i];
		for (int i = 0 ; i < b.length ; i++)
			r[a.length + i] = b[i];
		return r;
	}

	public static TreeNode parse(ILexer lex, GTools gt) throws Exception {
		TreeNode root = new TreeNode(gt.initialSymbol(), 0);
		int[] S = new int[1];
		S[0] = gt.initialSymbol();
		_nb_terminals = gt.numberOfTerminals();
		_parse_table = gt.parseTable();
		_gt = gt;
		Stack s = new Stack();
		s.push(root);
		_parse(S, lex, s);
		return root;
	}

	private static void _parse(int[] tau, ILexer lex, Stack s) throws Exception {
		if (tau.length == 0) {
			if (lex.getNextSymbol().getTerminal() == _nb_terminals)
				return;
			throw new Exception("Syntaxical exception");
		}
		int[] _tau = trimFirst(tau);
		// tau[0] is a terminal
		if (tau[0] < _nb_terminals) {
			IToken token = lex.getNextSymbol();
			int x = token.getTerminal();
			if (x == _nb_terminals || tau[0] != x)
				throw new Exception("Syntaxical exception");
			((TreeNode) s.pop()).putStringValue(token.getSymbol());
			_parse(_tau, lex, s);
			return;
		}
		// tau[0] is a non-terminal
		TreeNode root = (TreeNode) s.pop();
		int index = ((Lexer) lex).getIndex();
		int[] rule = _parse_table[tau[0] - _nb_terminals][lex.getNextSymbol().getTerminal()];
		if (rule == null)
			throw new Exception("Syntaxical exception");
		((Lexer) lex).setIndex(index);
		TreeNode[] children = new TreeNode[rule.length];
		for (int i = 0 ; i < rule.length ; i++)
			children[i] = new TreeNode(rule[i]);
		root.putChilds(_gt.ruleNumber(tau[0], rule), children);
		for (int i = children.length - 1 ; i > -1 ; i--)
			s.push(children[i]);
		_parse(append(rule, _tau), lex, s);
	}

}
