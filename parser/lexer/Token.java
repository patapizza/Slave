package lexer;

public class Token implements IToken {

	private int terminal;
	private String symbol;

	public Token(int terminal) {
		this.terminal = terminal;
		this.symbol = null;
	}

	public Token(int terminal, String symbol) {
		this.terminal = terminal;
		this.symbol = symbol;
	}

	// returns terminal number of symbol (or total number of terminals)
	public int getTerminal() {
		return terminal;
	}

	// returns symbol (if constant or identifier)
	public String getSymbol() {
		return symbol;
	}

}
