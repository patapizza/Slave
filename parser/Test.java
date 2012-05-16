import slip.grammars.*;

class Test {

	public static void main(String[] args) {
		try {
			new LL1Grammar(new Gr20_Grammar()).check();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
