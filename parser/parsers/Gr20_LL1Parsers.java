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

public class Gr20_LL1Parsers {

	private static int _nb_terminals;
	private static int[][][] _parse_table;

	public static boolean isOk(ILexer lex, GTools gt) throws Exception {
		int[] S = new int[1];
		S[0] = gt.initialSymbol();
		_nb_terminals = gt.numberOfTerminals();
		_parse_table = gt.parseTable();
		return TDD(S, lex);
	}

	private static boolean TDD(int[] tau, ILexer lex) throws Exception {
		if (tau.length == 0) {
			if (lex.getNextSymbol().getTerminal() == _nb_terminals)
				return true;
			return false;
		}
		int[] _tau = trimFirst(tau);
		// tau[0] is a terminal
		if (tau[0] < _nb_terminals) {
			int x = lex.getNextSymbol().getTerminal();
			if (x == _nb_terminals || tau[0] != x)
				return false;
			return TDD(_tau, lex);
		}
		// tau[0] is a non-terminal
		int[][] rules = _parse_table[tau[0] - _nb_terminals];
		int i, index;
		for (i = 0 ; i < rules.length ; i++) {
			index = ((Lexer) lex).getIndex();
			if (rules[i] != null && TDD(append(rules[i], _tau), lex))
				break;
			((Lexer) lex).setIndex(index);
		}
		return i < rules.length;
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
		return null;
	}

	public static void main(String[] args) {
		String s = "";
		File file = new File("lexer/tiny.source");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			while (dis.available() != 0)
				s += dis.readLine()+"\n";
			fis.close();
			bis.close();
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GTools gt = null;
		ILexer lex = null;
		try {
			gt = new GTools("Grammar_LL1.txt");
			lex = new Lexer(s, gt);
			if (Gr20_LL1Parsers.isOk(lex, gt))
				System.out.println("OK");
			else
				System.out.println("KO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
