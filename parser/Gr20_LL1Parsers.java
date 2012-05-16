package parsers;

import lexer.ILexer;
import lexer.IToken;
import slip.grammars.Grammar;
import slip.trees.TreeNode;
import gtools.GTools;

public class Gr20_LL1Parsers {

	public static boolean isOk(ILexer lex, GTools gt) throws Exception {
		int[] S = new int[1];
		S[0] = gt.initialSymbol();
		return TDND(S, lex);
	}

	private boolean TDND(int[] tau, ILexer lex) {
		if (tau.length == 0)
			if (lex.getNextSymbol().getTerminal() == gt.numberOfTerminals())
				return true;
			return false;
		// tau[0] is a terminal
		if (tau[0] < gt.numberOfTerminals()) {
			int x = lex.getNextSymbol().getTerminal();
			if (x == gt.numberOfTerminals() || tau[0] != x)
				return false;
			return TDND(trimFirst(tau), lex);
		}
		// tau[0] is a non-terminal
		int[][] rules = gt.parseTable()[tau[0] - gt.numberOfTerminals()];
		if (rules.length == 0)
			return false;
		return TDND(append(rules[0], trimFirst(tau)), lex);
	}

	private int[] trimFirst(int[] a) {
		int[] r = new int[a.length - 1];
		for (int i = 1 ; i < a.length ; i++)
			r[i - 1] = a[i];
		return r;
	}

	private int[] append(int[] a, int[] b) {
		int[] r = new int[a.length + b.length];
		for (int i = 0 ; i < a.length ; i++)
			r[i] = a[i];
		for (int i = 0 ; i < b.length ; i++)
			r[a.length + i] = b[i];
		return r;
	}

	public static TreeNode parse(ILexer lex, GTools gt) throws Exception {
		return new TreeNode();
	}

}
