public class Gr20_Grammar extends slip.grammars.Grammar {

	// number of terminals
	private static final int NT = 98;

	// number of non-terminals
	private static final int NNT = 42;

	// terminal symbols
	private static final int DIGIT_0 = 0;
	private static final int DIGIT_1 = 1;
	private static final int DIGIT_2 = 2;
	private static final int DIGIT_3 = 3;
	private static final int DIGIT_4 = 4;
	private static final int DIGIT_5 = 5;
	private static final int DIGIT_6 = 6;
	private static final int DIGIT_7 = 7;
	private static final int DIGIT_8 = 8;
	private static final int DIGIT_9 = 9;
	private static final int OP_MINUS = 10;
	private static final int TRUE = 11;
	private static final int FALSE = 12;
	private static final int LOWER_A = 13;
	private static final int LOWER_B = 14;
	private static final int LOWER_C = 15;
	private static final int LOWER_D = 16;
	private static final int LOWER_E = 17;
	private static final int LOWER_F = 18;
	private static final int LOWER_G = 19;
	private static final int LOWER_H = 20;
	private static final int LOWER_I = 21;
	private static final int LOWER_J = 22;
	private static final int LOWER_K = 23;
	private static final int LOWER_L = 24;
	private static final int LOWER_M = 25;
	private static final int LOWER_N = 26;
	private static final int LOWER_O = 27;
	private static final int LOWER_P = 28;
	private static final int LOWER_Q = 29;
	private static final int LOWER_R = 30;
	private static final int LOWER_S = 31;
	private static final int LOWER_T = 32;
	private static final int LOWER_U = 33;
	private static final int LOWER_V = 34;
	private static final int LOWER_W = 35;
	private static final int LOWER_X = 36;
	private static final int LOWER_Y = 37;
	private static final int LOWER_Z = 38;
	private static final int CAPS_A = 39;
	private static final int CAPS_B = 40;
	private static final int CAPS_C = 41;
	private static final int CAPS_D = 42;
	private static final int CAPS_E = 43;
	private static final int CAPS_F = 44;
	private static final int CAPS_G = 45;
	private static final int CAPS_H = 46;
	private static final int CAPS_I = 47;
	private static final int CAPS_J = 48;
	private static final int CAPS_K = 49;
	private static final int CAPS_L = 50;
	private static final int CAPS_M = 51;
	private static final int CAPS_N = 52;
	private static final int CAPS_O = 53;
	private static final int CAPS_P = 54;
	private static final int CAPS_Q = 55;
	private static final int CAPS_R = 56;
	private static final int CAPS_S = 57;
	private static final int CAPS_T = 58;
	private static final int CAPS_U = 59;
	private static final int CAPS_V = 60;
	private static final int CAPS_W = 61;
	private static final int CAPS_X = 62;
	private static final int CAPS_Y = 63;
	private static final int CAPS_Z = 64;
	private static final int QUOTES = 65;
	private static final int DOLLAR = 66;
	private static final int LEFT_BRACKET = 67;
	private static final int RIGHT_BRACKET = 68;
	private static final int OP_PLUS = 69;
	private static final int OP_TIMES = 70;
	private static final int OP_DIVIDE = 71;
	private static final int OP_MODULO = 72;
	private static final int LEFT_PARENTHESIS = 73;
	private static final int RIGHT_PARENTHESIS = 74;
	private static final int COMMA = 75;
	private static final int COMP_LOWERTHAN = 76;
	private static final int COMP_GREATERTHAN = 77;
	private static final int COMP_LOWERTHAN_OR_EQUALSTO = 78;
	private static final int COMP_GREATERTHAN_OR_EQUALSTO = 79;
	private static final int COMP_EQUALSTO = 80;
	private static final int COMP_DIFFERENTTHAN = 81;
	private static final int RESERVED_OR = 82;
	private static final int RESERVED_AND = 83;
	private static final int SEMICOLON = 84;
	private static final int RESERVED_IF = 85;
	private static final int RESERVED_ELSE = 86;
	private static final int RESERVED_FUNCTION = 87;
	private static final int LEFT_BRACE = 88;
	private static final int RIGHT_BRACE = 89;
	private static final int RESERVED_SAY = 90;
	private static final int RESERVED_LISTEN = 91;
	private static final int RESERVED_RETURN = 92;
	private static final int RESERVED_WHILE = 93;
	private static final int NOT = 94;
	private static final int RESERVED_LAMBDA = 95;
	private static final int RESERVED_MAP = 96;
	private static final int EQUAL = 97;
	
	// non-terminal symbols
	private static final int PROGRAM = 98;
	private static final int DIGIT = 99;
	private static final int NUMBER = 100;
	private static final int NUMBER1 = 101;
	private static final int SIGN = 102;
	private static final int INT = 103;
	private static final int BOOLEAN = 104;
	private static final int LOWER = 105;
	private static final int CAPS = 106;
	private static final int LETTER = 107;
	private static final int ALPHANUM = 108;
	private static final int ALPHANUM1 = 109;
	private static final int STRING = 110;
	private static final int IDENTIFIER = 111;
	private static final int IDENTIFIER0 = 112;
	private static final int ARRAY = 113;
	private static final int ARRAY_LIST = 114;
	private static final int ARRAY_LIST0 = 115;
	private static final int OPERATOR = 116;
	private static final int EXPRESSION0 = 117;
	private static final int EXPRESSION = 118;
	private static final int EXPRESSION1 = 119;
	private static final int LAMBDA_EXPRESSION = 120;
	private static final int EXPRESSION_LIST = 121;
	private static final int EXPRESSION_LIST0 = 122;
	private static final int BOOLEAN_EXPRESSION = 123;
	private static final int BOOLEAN_EXPRESSION0 = 124;
	private static final int CONDITION = 125;
	private static final int COMPARATOR = 126;
	private static final int BOOLEAN_OPERATOR = 127;
	private static final int ARG0 = 128;
	private static final int ARG = 129;
	private static final int FNAME = 130;
	private static final int DECLARATION = 131;
	private static final int DECLARATION0 = 132;
	private static final int IF = 133;
	private static final int IF0 = 134;
	private static final int FUNCTION = 135;
	private static final int RETURN = 136;
	private static final int STATEMENT0 = 137;
	private static final int STATEMENT = 138;
	private static final int STATEMENT_LIST = 139;
	
	// production rules
	private static final int[][][] pRonde = 
	{
		{ {STATEMENT} },
		{ {DIGIT_0}, {DIGIT_1}, {DIGIT_2}, {DIGIT_3}, {DIGIT_4}, {DIGIT_5}, {DIGIT_6}, {DIGIT_7}, {DIGIT_8}, {DIGIT_9} },
		{ {DIGIT, NUMBER1} },
		{ {}, {NUMBER} },
		{ {}, {OP_MINUS} },
		{ {SIGN, NUMBER} },
		{ {TRUE}, {FALSE} },
		{ {LOWER_A}, {LOWER_B}, {LOWER_C}, {LOWER_D}, {LOWER_E}, {LOWER_F}, {LOWER_G}, {LOWER_H}, {LOWER_I}, {LOWER_J}, {LOWER_K}, {LOWER_L}, {LOWER_M}, {LOWER_N}, {LOWER_O}, {LOWER_P}, {LOWER_Q}, {LOWER_R}, {LOWER_S}, {LOWER_T}, {LOWER_U}, {LOWER_V}, {LOWER_W}, {LOWER_X}, {LOWER_Y}, {LOWER_Z} },
		{ {CAPS_A}, {CAPS_B}, {CAPS_C}, {CAPS_D}, {CAPS_E}, {CAPS_F}, {CAPS_G}, {CAPS_H}, {CAPS_I}, {CAPS_J}, {CAPS_K}, {CAPS_L}, {CAPS_M}, {CAPS_N}, {CAPS_O}, {CAPS_P}, {CAPS_Q}, {CAPS_R}, {CAPS_S}, {CAPS_T}, {CAPS_U}, {CAPS_V}, {CAPS_W}, {CAPS_X}, {CAPS_Y}, {CAPS_Z} },
		{ {LOWER}, {CAPS} },
		{ {}, {ALPHANUM1, ALPHANUM} },
		{ {LETTER}, {DIGIT} },
		{ {QUOTES, ALPHANUM, QUOTES} },
		{ {DOLLAR, IDENTIFIER0} },
		{ {LOWER, ALPHANUM, ARRAY}, {NUMBER} },
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
		{ {LOWER, ALPHANUM} },
		{ {IDENTIFIER, DECLARATION0} },
		{ {SEMICOLON}, {EQUAL, EXPRESSION, SEMICOLON} },
		{ {RESERVED_IF, LEFT_PARENTHESIS, CONDITION, RIGHT_PARENTHESIS, LEFT_BRACE, STATEMENT, RIGHT_BRACE, IF0} },
		{ {RESERVED_ELSE, LEFT_BRACE, STATEMENT, RIGHT_BRACE}, {} },
		{ {RESERVED_FUNCTION, FNAME, LEFT_PARENTHESIS, ARG, RIGHT_PARENTHESIS, LEFT_BRACE, STATEMENT_LIST, RETURN, RIGHT_BRACE} },
		{ {RESERVED_RETURN, EXPRESSION, SEMICOLON} },
		{ {DECLARATION}, {RESERVED_WHILE, LEFT_PARENTHESIS, CONDITION, RIGHT_PARENTHESIS, LEFT_BRACE, STATEMENT, RIGHT_BRACE}, {IF}, {RESERVED_SAY, LEFT_PARENTHESIS, EXPRESSION, RIGHT_PARENTHESIS, SEMICOLON}, {RESERVED_LISTEN, LEFT_PARENTHESIS, RIGHT_PARENTHESIS, SEMICOLON}, {FUNCTION}, {RESERVED_MAP, LEFT_PARENTHESIS, LAMBDA_EXPRESSION, COMMA, IDENTIFIER, RIGHT_PARENTHESIS, SEMICOLON} },
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
			case DIGIT_0: return "0";
			case DIGIT_1: return "1";
			case DIGIT_2: return "2";
			case DIGIT_3: return "3";
			case DIGIT_4: return "4";
			case DIGIT_5: return "5";
			case DIGIT_6: return "6";
			case DIGIT_7: return "7";
			case DIGIT_8: return "8";
			case DIGIT_9: return "9";
			case OP_MINUS: return "-";
			case TRUE: return "true";
			case FALSE: return "false";
			case LOWER_A: return "a";
			case LOWER_B: return "b";
			case LOWER_C: return "c";
			case LOWER_D: return "d";
			case LOWER_E: return "e";
			case LOWER_F: return "f";
			case LOWER_G: return "g";
			case LOWER_H: return "h";
			case LOWER_I: return "i";
			case LOWER_J: return "j";
			case LOWER_K: return "k";
			case LOWER_L: return "l";
			case LOWER_M: return "m";
			case LOWER_N: return "n";
			case LOWER_O: return "o";
			case LOWER_P: return "p";
			case LOWER_Q: return "q";
			case LOWER_R: return "r";
			case LOWER_S: return "s";
			case LOWER_T: return "t";
			case LOWER_U: return "u";
			case LOWER_V: return "v";
			case LOWER_W: return "w";
			case LOWER_X: return "x";
			case LOWER_Y: return "y";
			case LOWER_Z: return "z";
			case CAPS_A: return "A";
			case CAPS_B: return "B";
			case CAPS_C: return "C";
			case CAPS_D: return "D";
			case CAPS_E: return "E";
			case CAPS_F: return "F";
			case CAPS_G: return "G";
			case CAPS_H: return "H";
			case CAPS_I: return "I";
			case CAPS_J: return "J";
			case CAPS_K: return "K";
			case CAPS_L: return "L";
			case CAPS_M: return "M";
			case CAPS_N: return "N";
			case CAPS_O: return "O";
			case CAPS_P: return "P";
			case CAPS_Q: return "Q";
			case CAPS_R: return "R";
			case CAPS_S: return "S";
			case CAPS_T: return "T";
			case CAPS_U: return "U";
			case CAPS_V: return "V";
			case CAPS_W: return "W";
			case CAPS_X: return "X";
			case CAPS_Y: return "Y";
			case CAPS_Z: return "Z";
			case QUOTES: return "\"";
			case DOLLAR: return "$";
			case LEFT_BRACKET: return "[";
			case RIGHT_BRACKET: return "]";
			case OP_PLUS: return "+";
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
			case NUMBER: return "<number>";
			case NUMBER1: return "<number1>";
			case SIGN: return "<sign>";
			case INT: return "<int>";
			case BOOLEAN: return "<boolean>";
			case LOWER: return "<lower>";
			case CAPS: return "<caps>";
			case LETTER: return "<letter>";
			case ALPHANUM: return "<alphanum>";
			case ALPHANUM1: return "<alphanum1>";
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
			case DIGIT: return "<digit>";
			case BOOLEAN_EXPRESSION: return "<boolean_expression>";
			case BOOLEAN_EXPRESSION0: return "<boolean_expression0>";
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
