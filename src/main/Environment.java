package main;

import java.util.HashMap;

import value.Array;
import value.Type;
import value.Value;
import expression.ArrayElement;
import expression.Identifier;
import expression.FName;

public class Environment {

	HashMap<String, Type> map;
	HashMap<String, Parameter> fun;

	Environment() {
		map = new HashMap<String, Type>();
		fun = new HashMap<String, Parameter>();
	}

	public boolean add(Identifier i, Type t) {
		if (map.get(i.getName()) != null)
			return false;
		map.put(i.getName(), t);
		return true;
	}

	public Type getValue(Identifier i) {
		return map.get(i.getName());
	}

	public Type getElement(ArrayElement ae) {
		Array a = (Array) map.get(ae.getId().getName());
		return a.get(ae.getIndex());
	}

	public Array getArray(Identifier i) {
		return (Array) map.get(i.getName());
	}

	public boolean setElement(ArrayElement ae, Type t) {
		Array a = (Array) map.get(ae.getId().getName());
		if (a == null)
			return false;
		a.set(ae.getIndex(), t);
		return true;
	}

	public boolean update(Identifier i, Type v) {
		map.put(i.getName(), v);
		return true;
	}

	public boolean add(FName fname, Parameter p) {
		if (fun.get(fname.getName()) != null)
			return false;
		fun.put(fname.getName(), p);
		return true;
	}

	public Parameter getFun(FName fname) {
		return fun.get(fname.getName());
	}

}
