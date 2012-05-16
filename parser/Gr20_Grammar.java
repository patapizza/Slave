public class Gr20_Grammar extends slip.grammars.Grammar {

	// number of terminals
	private static final int NT = 44;

	// number of non-terminals
	private static final int NNT = 33;

	// terminal symbols
	private static final int TRUE = 0;
	private static final int FALSE = 1;
	private static final int QUOTES = 2;
	private static final int DOLLAR = 3;
	private static final int LEFT_BRACKET = 4;
	private static final int RIGHT_BRACKET = 5;
	private static final int OP_PLUS = 6;
	private static final int OP_MINUS = 7;
	private static final int OP_TIMES = 8;
	private static final int OP_DIVIDE = 9;
	private static final int OP_MODULO = 10;
	private static final int LEFT_PARENTHESIS = 11;
	private static final int RIGHT_PARENTHESIS = 12;
	private static final int COMMA = 13;
	private static final int COMP_LOWERTHAN = 14;
	private static final int COMP_GREATERTHAN = 15;
	private static final int COMP_LOWERTHAN_OR_EQUALSTO = 16;
	private static final int COMP_GREATERTHAN_OR_EQUALSTO = 17;
	private static final int COMP_EQUALSTO = 18;
	private static final int COMP_DIFFERENTTHAN = 19;
	private static final int RESERVED_OR = 20;
	private static final int RESERVED_AND = 21;
	private static final int SEMICOLON = 22;
	private static final int RESERVED_IF = 23;
	private static final int RESERVED_ELSE = 24;
	private static final int RESERVED_FUNCTION = 25;
	private static final int LEFT_BRACE = 26;
	private static final int RIGHT_BRACE = 27;
	private static final int RESERVED_SAY = 28;
	private static final int RESERVED_LISTEN = 29;
	private static final int RESERVED_RETURN = 30;
	private static final int RESERVED_WHILE = 31;
	private static final int NOT = 32;
	private static final int RESERVED_LAMBDA = 33;
	private static final int RESERVED_MAP = 34;
	private static final int EQUAL = 35;
	private static final int RESERVED_ARRAY = 36;
	private static final int RESERVED_SIZE = 37;
	private static final int RESERVED_READ = 38;
	private static final int RESERVED_WRITE = 39;

	// terminal symbols from the lexer
	private static final int LEX_ID = 40;
	private static final int LEX_INT = 41;
	private static final int LEX_STR = 42;
	private static final int LEX_FNAME = 43;
	
	// non-terminal symbols
	private static final int PROGRAM = 44;
	private static final int INT = 45;
	private static final int BOOLEAN = 46;
	private static final int STRING = 47;
	private static final int IDENTIFIER = 48;
	private static final int IDENTIFIER0 = 49;
	private static final int ARRAY = 50;
	private static final int ARRAY_LIST = 51;
	private static final int ARRAY_LIST0 = 52;
	private static final int OPERATOR = 53;
	private static final int EXPRESSION0 = 54;
	private static final int EXPRESSION = 55;
	private static final int EXPRESSION1 = 56;
	private static final int LAMBDA_EXPRESSION = 57;
	private static final int EXPRESSION_LIST = 58;
	private static final int EXPRESSION_LIST0 = 59;
	private static final int BOOLEAN_EXPRESSION = 60;
	private static final int BOOLEAN_EXPRESSION0 = 61;
	private static final int CONDITION = 62;
	private static final int COMPARATOR = 63;
	private static final int BOOLEAN_OPERATOR = 64;
	private static final int ARG0 = 65;
	private static final int ARG = 66;
	private static final int FNAME = 67;
	private static final int DECLARATION = 68;
	private static final int DECLARATION0 = 69;
	private static final int IF = 70;
	private static final int IF0 = 71;
	private static final int FUNCTION = 72;
	private static final int RETURN = 73;
	private static final int STATEMENT0 = 74;
	private static final int STATEMENT = 75;
	private static final int STATEMENT_LIST = 76;
	
	// production rules
	private static final int[][][] pRonde = 
	{
		{ {STATEMENT} },
		{ {LEX_INT} },
		{ {TRUE}, {FALSE} },
		{ {QUOTES, LEX_STR, QUOTES} },
		{ {DOLLAR, IDENTIFIER0} },
		{ {LEX_ID, ARRAY} },
		{ {}, {ARRAY_LIST} },
		{ {LEFT_BRACKET, EXPRESSION, RIGHT_BRACKET, ARRAY_LIST0} },
		{ {}, {ARRAY_LIST} },
		{ {OP_PLUS}, {OP_MINUS}, {OP_TIMES}, {OP_DIVIDE}, {OP_MODULO} },
		{ {INT}, {IDENTIFIER}, {STRING}, {FNAME, LEFT_PARENTHESIS, EXPRESSION_LIST, RIGHT_PARENTHESIS}, {LEFT_PARENTHESIS, EXPRESSION, RIGHT_PARENTHESIS}, {LAMBDA_EXPRESSION} },
		{ {EXPRESSION0, EXPRESSION1} },
		{ {}, {OPERATOR, EXPRESSION} },
		{ {RESERVED_LAMBDA, LEFT_PARENTHESIS, ARG0, RIGHT_PARENTHESIS, LEFT_BRACE, RETURN, RIGHT_BRACE} },
		{ {EXPRESSION, EXPRESSION_LIST0} },
		{ {}, {COMMA, EXPRESSION_LIST} },
		{ {BOOLEAN}, {EXPRESSION, BOOLEAN_EXPRESSION0}, {NOT, BOOLEAN_EXPRESSION} },
		{ {COMPARATOR, EXPRESSION}, {BOOLEAN_OPERATOR, EXPRESSION}, {} },
		{ {BOOLEAN_EXPRESSION} },
		{ {COMP_LOWERTHAN}, {COMP_LOWERTHAN_OR_EQUALSTO}, {COMP_GREATERTHAN}, {COMP_GREATERTHAN_OR_EQUALSTO}, {COMP_EQUALSTO}, {COMP_DIFFERENTTHAN} },
		{ {RESERVED_OR}, {RESERVED_AND} },
		{ {IDENTIFIER, ARG} },
		{ {}, {COMMA, ARG0} },
		{ {LEX_FNAME} },
		{ {IDENTIFIER, DECLARATION0} },
		{ {SEMICOLON}, {EQUAL, EXPRESSION, SEMICOLON} },
		{ {RESERVED_IF, LEFT_PARENTHESIS, CONDITION, RIGHT_PARENTHESIS, LEFT_BRACE, STATEMENT, RIGHT_BRACE, IF0} },
		{ {RESERVED_ELSE, LEFT_BRACE, STATEMENT, RIGHT_BRACE}, {} },
		{ {RESERVED_FUNCTION, FNAME, LEFT_PARENTHESIS, ARG, RIGHT_PARENTHESIS, LEFT_BRACE, STATEMENT_LIST, RETURN, RIGHT_BRACE} },
		{ {RESERVED_RETURN, EXPRESSION, SEMICOLON} },
		{ {DECLARATION}, {RESERVED_WHILE, LEFT_PARENTHESIS, CONDITION, RIGHT_PARENTHESIS, LEFT_BRACE, STATEMENT, RIGHT_BRACE}, {IF}, {RESERVED_SAY, LEFT_PARENTHESIS, EXPRESSION, RIGHT_PARENTHESIS, SEMICOLON}, {RESERVED_LISTEN, LEFT_PARENTHESIS, RIGHT_PARENTHESIS, SEMICOLON}, {FUNCTION}, {RESERVED_MAP, LEFT_PARENTHESIS, LAMBDA_EXPRESSION, COMMA, IDENTIFIER, RIGHT_PARENTHESIS, SEMICOLON}, {RESERVED_READ, LEFT_PARENTHESIS, IDENTIFIER, RIGHT_PARENTHESIS, SEMICOLON}, {RESERVED_WRITE, LEFT_PARENTHESIS, IDENTIFIER, RIGHT_PARENTHESIS, SEMICOLON}, {RESERVED_SIZE, LEFT_PARENTHESIS, IDENTIFIER, COMMA, IDENTIFIER, RIGHT_PARENTHESIS, SEMICOLON}, {RESERVED_ARRAY, LEFT_PARENTHESIS, IDENTIFIER, COMMA, INT, RIGHT_PARENTHESIS, SEMICOLON} },
		{ {STATEMENT0, STATEMENT_LIST} },
		{ {}, {STATEMENT} }
	};

	public Gr20_Grammar() {
	}

	public int numberOfTerminals() {
		return NT;
	}

	public int numberOfNonTerminals() {
		return NNT;
	}

	public int[][][] productionRules() {
		return pRonde;
	}

	public int initialSymbol() {
		return PROGRAM;
	}

	public String symbol(int i) {
		switch (i) {
			case TRUE: return "true";
			case FALSE: return "false";
			case QUOTES: return "\"";
			case DOLLAR: return "$";
			case LEFT_BRACKET: return "[";
			case RIGHT_BRACKET: return "]";
			case OP_PLUS: return "+";
			case OP_MINUS: return "-";
			case OP_TIMES: return "*";
			case OP_DIVIDE: return "/";
			case OP_MODULO: return "%";
			case LEFT_PARENTHESIS: return "(";
			case RIGHT_PARENTHESIS: return ")";
			case COMMA: return ",";
			case COMP_LOWERTHAN: return "<";
			case COMP_GREATERTHAN: return ">";
			case COMP_LOWERTHAN_OR_EQUALSTO: return "<=";
			case COMP_GREATERTHAN_OR_EQUALSTO: return ">=";
			case COMP_EQUALSTO: return "==";
			case COMP_DIFFERENTTHAN: return "!=";
			case RESERVED_OR: return "or";
			case RESERVED_AND: return "and";
			case SEMICOLON: return ";";
			case RESERVED_IF: return "if";
			case RESERVED_ELSE: return "else";
			case RESERVED_FUNCTION: return "function";
			case LEFT_BRACE: return "{";
			case RIGHT_BRACE: return "}";
			case RESERVED_SAY: return "say";
			case RESERVED_LISTEN: return "listen";
			case RESERVED_RETURN: return "return";
			case RESERVED_WHILE: return "while";
			case NOT: return "!";
			case RESERVED_LAMBDA: return "lambda";
			case RESERVED_MAP: return "map";
			case EQUAL: return "=";
			case INT: return "<int>";
			case BOOLEAN: return "<boolean>";
			case STRING: return "<string>";
			case ARRAY: return "<array>";
			case IDENTIFIER: return "<identifier>";
			case IDENTIFIER0: return "<identifier0>";
			case ARRAY_LIST: return "<array_list>";
			case ARRAY_LIST0: return "<array_list0>";
			case EXPRESSION: return "<expression>";
			case OPERATOR: return "<operator>";
			case EXPRESSION0: return "<expression0>";
			case FNAME: return "<fname>";
			case EXPRESSION_LIST: return "<expression_list>";
			case EXPRESSION1: return "<expression1>";
			case EXPRESSION_LIST0: return "<expression_list0>";
			case CONDITION: return "<condition>";
			case COMPARATOR: return "<comparator>";
			case BOOLEAN_OPERATOR: return "<boolean_operator>";
			case ARG: return "<arg>";
			case ARG0: return "<arg0>";
			case DECLARATION: return "<declaration>";
			case DECLARATION0: return "<declaration0>";
			case IF: return "<if>";
			case IF0: return "<if0>";
			case FUNCTION: return "<function>";
			case RETURN: return "<return>";
			case STATEMENT0: return "<statement0>";
			case STATEMENT_LIST: return "<statement_list>";
			case PROGRAM: return "<program>";
			case STATEMENT: return "<statement>";
			case LAMBDA_EXPRESSION: return "<lambda_expression>";
			case BOOLEAN_EXPRESSION: return "<boolean_expression>";
			case BOOLEAN_EXPRESSION0: return "<boolean_expression0>";
			case RESERVED_READ: return "read";
			case RESERVED_WRITE: return "write";
			case RESERVED_ARRAY: return "array";
			case RESERVED_SIZE: return "size";
			case LEX_ID: return "LEX_ID";
			case LEX_INT: return "LEX_INT";
			case LEX_STR: return "LEX_STR";
			case LEX_FNAME: return "LEX_FNAME";
			default: return "[unknown symbol]";
		}
	}

	public String name() {
		return "Gr20_Grammar";
	}

	public static void main(String[] args) {
		slip.grammars.Grammar g = new Gr20_Grammar();
		System.out.println("Description de la grammaire " + g.name());
		System.out.println("---------------------------------------");
		System.out.println(g);
	}

}
