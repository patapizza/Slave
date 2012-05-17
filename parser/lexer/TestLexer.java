package lexer;

import slip.grammars.*;
import gtools.GTools;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;

class TestLexer {

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		IToken token = null;
		do {
			try {
				token = lex.getNextSymbol();
				//System.out.println(gt.parseTable()[token.getTerminal()-gt.numberOfTerminals()]);
				System.out.print(token.getSymbol()+" ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (token.getTerminal() != gt.numberOfTerminals());
		System.out.println("");
		/*try {
			int[][][] pt = gt.parseTable();
			for (int i = 0 ; i < pt.length ; i++)
				for (int j = 0 ; j < pt[i].length ; j++)
					if (pt[i][j] != null) {
						for (int k = 0 ; k < pt[i][j].length ; k++)
							System.out.print(pt[i][j][k] + " ");
						System.out.println("---");
					}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
