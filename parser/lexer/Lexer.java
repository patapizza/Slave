package lexer;

public class Lexer implements ILexer {

	private IToken[] tokens;
	private int index;

	public Lexer(String s) {
		index = 0;
		// wrong ; TODO
		String[] words = s.split();
		tokens = new Token[words.length];
		for (int i = 0 ; i < words.length ; i++) {
			tokens[i] = new Token();
		}
	}

	// returns token of first symbol not yet sent (if any; else, returns token with total number of terminals
	// throws exception if unmappable character
	public IToken getNextSymbol() throws Exception {
		if (index == tokens.length)
			return NT;
		return tokens[index++];
	}

}
