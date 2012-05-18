import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;

import gtools.GTools;
import slip.grammars.Grammar;
import slip.trees.TreeNode;
import parsers.LL1Parsers;

import lexer.ILexer;
import lexer.Lexer;
import main.Interpreter;

class Slave {

	public static void main(String[] args) {
		String s = "";
		File file = new File(args[0]);
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			while (dis.available() != 0)
				s += dis.readLine() + "\n";
			fis.close();
			bis.close();
			dis.close();
			GTools gt = new GTools("parser/Grammar_LL1.txt");
			ILexer lex = new Lexer(s, gt);
			TreeNode root = LL1Parsers.parse(lex, gt);
			new Interpreter(ST2AST.tradProgram(root), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
