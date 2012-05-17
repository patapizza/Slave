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

	public static boolean isOk(ILexer lex, GTools gt) throws Exception {
		int[] S = new int[1];
		S[0] = gt.initialSymbol();
		return TDD(S, lex, gt);
	}

	private static boolean TDD(int[] tau, ILexer lex, GTools gt) throws Exception {
		if (tau.length == 0) {
			if (lex.getNextSymbol().getTerminal() == gt.numberOfTerminals())
				return true;
			return false;
		}
		// tau[0] is a terminal
		if (tau[0] < gt.numberOfTerminals()) {
			int x = lex.getNextSymbol().getTerminal();
			if (x == gt.numberOfTerminals() || tau[0] != x)
				return false;
			return TDD(trimFirst(tau), lex, gt);
		}
		// tau[0] is a non-terminal
		int[][] rules = gt.parseTable()[tau[0] - gt.numberOfTerminals()];
		int i;
		for (i = 0 ; i < rules.length ; i++)
			if (rules[i] != null && TDD(append(rules[i], trimFirst(tau)), lex, gt))
				break;
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
		File file = new File("lexer/program.source");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			while (dis.available() != 0)
				s += dis.readLine();
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
