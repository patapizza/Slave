package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import expression.*;
import statement.*;
import value.*;

public class Interpreter {

	private Environment env;

	public Interpreter(Statement AST, Type[] args) {
		/* 
		 * args contains the arguments of the program.
		 * These are inserted in the environment with the name $0, $1, $2, ..., $(args.length - 1)
		 *  */
		env = new Environment();
		if (args != null) {
			Identifier id = new Identifier();
			for (int i = 0; i < args.length; i++) {
				id.bypass("$" + i);
				env.add(id, args[i]);
			}
		}
		instr(AST, env);
	}

	public Type eval(Expression e, Environment env) {
			if (e instanceof Constant)
				return ((Constant) e).getValue();
			else if (e instanceof BooleanE)
				return ((BooleanE) e).getValue();
			else if (e instanceof StringE)
				return ((StringE) e).getValue();
			else if (e instanceof ArrayElement) {
				((ArrayElement) e).setIndex(((IntValue) eval(((ArrayElement) e).getExpression(), env)).intValue());
				return env.getElement((ArrayElement) e);
			}
			else if (e instanceof Identifier) {
				Type v = env.getValue((Identifier) e);
				if (v == null) {
					System.err.println("The identifier " + ((Identifier) e).getName() + " is not linked to a value");
					System.exit(1);
				}
				return v;
			}
			else if (e instanceof Call) {
				Environment env2 = new Environment();
				Parameter p = env.getFun(((Call) e).getName());
				List<Expression> exprs = ((Call) e).getArgs();
				List<Identifier> ids = p.getArgs();
				for (int i = 0 ; i < exprs.size() ; i++)
					if (!env2.add(ids.get(i), eval(exprs.get(i), env))){
						System.err.println("An error occurred while calling the function " + ((Call) e).getName());
						System.exit(1);
					}
				Identifier id = new Identifier();
				id.bypass("$_");
				env2.add(id, new IntValue(42));
				Environment env3 = instr(p.getBody(), env2);
				return env3.getValue(id);
			}
			else if (e instanceof Lambda) {
				Environment env2 = new Environment();
				List<Identifier> args = ((Lambda) e).getArgs();
				List<Value> values = ((Lambda) e).getArgsValues();
				for (int i = 0 ; i < args.size() ; i++)
					if (!env2.add(args.get(i), values.get(i))) {
						System.err.println("An error occourred  while evaluating lambda expression");
						System.exit(1);
					}
				Identifier id = new Identifier();
				id.bypass("$_");
				env2.add(id, new IntValue(42));
				Environment env3 = instr(((Lambda) e).getBody(), env2);
				return env3.getValue(id);
			}
			else if (e instanceof Subtraction)
				return Value.subtract((Value)eval(((Subtraction) e).getLeft(), env),(Value) eval(((Subtraction) e).getRight(), env));
			else if (e instanceof Addition)
				return Value.add((Value)eval(((Addition) e).getLeft(), env), (Value)eval(((Addition) e).getRight(), env));
			else if (e instanceof Multiplication)
				return Value.multiply((Value)eval(((Multiplication) e).getLeft(), env), (Value)eval(((Multiplication) e).getRight(), env));
			else if (e instanceof Division)
				return Value.divide((Value)eval(((Division) e).getLeft(), env), (Value)eval(((Division) e).getRight(), env));
			else if (e instanceof Modulo)
				return Value.modulo((Value)eval(((Modulo) e).getLeft(), env), (Value)eval(((Modulo) e).getRight(), env));
			else if (e instanceof GreaterThan)
				return Value.greaterThan((Value)eval(((GreaterThan) e).getLeft(), env), (Value)eval(((GreaterThan) e).getRight(), env));
			else if (e instanceof GreaterThanOrEqualsTo)
				return Value.greaterThanOrEqualsTo((Value)eval(((GreaterThanOrEqualsTo) e).getLeft(), env), (Value)eval(((GreaterThanOrEqualsTo) e).getRight(), env));
			else if (e instanceof LessThan)
				return Value.lessThan((Value)eval(((LessThan) e).getLeft(), env), (Value)eval(((LessThan) e).getRight(), env));
			else if (e instanceof LessThanOrEqualsTo)
				return Value.lessThanOrEqualsTo((Value)eval(((LessThanOrEqualsTo) e).getLeft(), env), (Value)eval(((LessThanOrEqualsTo) e).getRight(), env));
			else if (e instanceof Different)
				return Value.different((Value)eval(((Different) e).getLeft(), env), (Value)eval(((Different) e).getRight(), env));
			else if (e instanceof EqualsTo)
				return Value.equalsTo((Value)eval(((EqualsTo) e).getLeft(), env), (Value)eval(((EqualsTo) e).getRight(), env));
			else if (e instanceof And)
				return Value.and((Value)eval(((And) e).getLeft(), env), (Value)eval(((And) e).getRight(), env));
			else if (e instanceof Or)
				return Value.or((Value)eval(((Or) e).getLeft(), env), (Value)eval(((Or) e).getRight(), env));
			else if (e instanceof Not)
				return Value.not((Value)eval(((Not) e).getLeft(), env));
		System.err.println("Unknown expression");
		return new BooleanValue(false);
	}

	public Environment instr(Statement s, Environment env) {
		if (s instanceof If) {
			if (((BooleanValue) eval(((If) s).getLeft(), env)).booleanValue())
				return instr(((If) s).getMiddle(), env);
			else if (((If) s).getRight() != null) /* else part */
				return instr(((If) s).getRight(), env);
			// nothing to do
			return env;
		}
		else if (s instanceof While) {
			while (((BooleanValue) eval(((While) s).getLeft(), env)).booleanValue())
				env = instr(((While) s).getRight(), env);
			return env;
		}
		else if (s instanceof Declaration) {
			if (!env.add(((Declaration)s).getId(), null)) {
				System.err.println("An error occured while declarating " + ((Declaration)s).getId().getName());
				System.exit(1);
			}
			return env;
		}
		else if (s instanceof ArrayDeclaration) {
			if (!env.add(((ArrayDeclaration) s).getId(), ((ArrayDeclaration) s).getArray())){
				System.err.println("An error occurred while declarating the array " + ((ArrayDeclaration) s).getId().getName());
				System.exit(1);
			}
			return env;
		}
		else if (s instanceof Assignation) {
			Identifier i = ((Assignation) s).getLeft();
			if (i instanceof ArrayElement) {
				((ArrayElement) i).setIndex(((IntValue) eval(((ArrayElement) i).getExpression(), env)).intValue());
				if (!env.setElement((ArrayElement) i, eval(((Assignation) s).getRight(), env))) {
					System.err.println("An error occurred while assigning the ArrayElement " + ((ArrayElement) i).getId().getName());
					System.exit(1);
				}
			}
			else
				env.update(i, eval(((Assignation) s).getRight(), env));
			return env;
		}
		else if (s instanceof Say) {
			System.out.println("" + eval(((Say) s).getLeft(), env));
			return env;
		}
		else if (s instanceof Listen) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String ss;
			try {
				ss = in.readLine();
				env.update(((Listen) s).getId(), new StringValue(ss));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return env;
		}
		else if (s instanceof Size) {
			Array a = env.getArray(((Size) s).getArrayId());
			env.update(((Size) s).getVarId(), new IntValue(a.getLength()));
			return env;
		}
		else if (s instanceof Write) {
			FileWriter writer = null;
			String text = ((StringValue) eval(((Write) s).getRight(), env)).stringValue();
			try {
			     writer = new FileWriter(((StringValue) eval(((Write) s).getLeft(), env)).stringValue(), true);
			     writer.write(text, 0, text.length());
			}
			catch (IOException ex) {
			    ex.printStackTrace();
			}
			finally {
				if (writer != null)
			     		try {
						writer.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
			}
			return env;
			
		}
		else if (s instanceof Read) {
			Scanner scanner = null;
			try {
				scanner = new Scanner(new File(((StringValue) eval(((Read) s).getLeft(), env)).stringValue()));
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String contents = "";	
			while (scanner.hasNextLine())
				contents += scanner.nextLine() + "\n";
			env.update(((Read) s).getRight(), new StringValue(contents));
			return env;
		}
		else if (s instanceof Function) {
			if (!env.add(((Function) s).getName(), new Parameter(((Function) s).getArgs(), ((Function) s).getBody()))){
				System.err.println("An error occurred while declaring the function " + ((Function)s).getName());
				System.exit(1);
			}
			return env;
		}
		else if (s instanceof Sequence) {
			Environment env2 = instr(((Sequence) s).getLeft(), env);
			return instr(((Sequence) s).getRight(), env2);
		}
		else if (s instanceof Return) {
			Identifier id = new Identifier();
			id.bypass("$_");
			env.update(id, eval(((Return)s).getExpression(), env));
			return env;
		}
		else if (s instanceof Map) {
			Array a = (Array) eval(((Map) s).getRight(), env);
			Lambda l = ((Map) s).getLeft();
			for (int i = 0 ; i < a.getLength() ; i++) {
				LinkedList<Value> list = new LinkedList<Value>();
				list.add((Value) a.get(i));
				l.setArgs(list);
				a.set(i, eval(l, env));
			}
			return env;
		}
		System.err.println("Unknown statement!");
		return env;
	}

}
