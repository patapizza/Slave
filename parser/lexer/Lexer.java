package lexer;

public class Lexer implements ILexer {

	private IToken[] tokens;
	private int index;
	private IToken last;

	public Lexer(String s, GTools gt) {
		index = 0;
		String symbols = clean(s);
		tokens = new Token[symbols.length];
		last = new Token(gt.numberOfTerminals());
		analyze(symbols);
	}

	// returns token of first symbol not yet sent (if any; else, returns token with total number of terminals
	// throws exception if unmappable character
	public IToken getNextSymbol() throws Exception {
		if (index == tokens.length)
			return last;
		return tokens[index++];
	}

	// returns the source clean code, that is, after removal of [\n \t]
	private String clean(String s) {
		return s.replaceAll("[\n \t]+", " ");
	}

	private void analyze(String s) {
		String[] reservedWords = { "lambda", "map", "true", "false", "if", "else", "function", "return", "while", "or", "and", "say", "listen", "size", "array", "read", "write", "<=", ">=", "==", "!=" };
		char[] singletons = { '(', ')', '{', '}', ';', '=', '+', '-', '*', '/', '%', '!', '[', ']', ',', '<', '>' };
		int j;
		int i = 0;
		boolean inString = false;
		boolean inIdentifier = false;
		// wrong! TODO: LEX_STR, LEX_INT, LEX_FNAME, LEX_ID for constants and identifiers!
		while (i < s.length) {
			// we are inside a string until next quote
			if (inString) {
				char c = s.charAt(i);
				tokens[index++] = new Token(gt.terminal(c.toString()), c.toString());
				++i;
				if (c == '"')
					inString = false;
				continue;
			}
			// we are between a '$' and a non alphanum character
			if (inIdentifier) {
				String c = s.substring(i, i);
				if (c.matches("[A-Za-z0-9]")) {
					tokens[index++] = new Token(gt.terminal(c), c);
					++i;
				}
				else
					inIdentifier = false;
				continue;
			}
			// reserved words
			for (int r = 0 ; r < reservedWords.length ; r++)
				if (s.startsWith(reservedWords[r], i)) {
					tokens[index++] = new Token(gt.terminal(s.substring(i, i + reservedWords[r].length)));
					i += reservedWords[r].length;
					break;
				}
			if (r < reservedWords.length)
				continue;
			// strings
			if (s.startsWith("\"", i)) {
				inString = true;
				tokens[index++] = new Token(gt.terminal("\""), "\"");
			}
			// identifiers
			if (s.charAt(i) == '$') {
				inIdentifier = true;
				tokens[index++] = new Token(gt.terminal("$"), "$");
			}
			// singletons
			for (int r = 0 ; r < singletons.length ; r++)
				if (s.charAt(i) == singletons[r]) {
					tokens[index++] = new Token(gt.terminal(singletons[r].toString()));
					break;
				}
			++i;
		}
	}

}
