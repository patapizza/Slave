package slip.trees;
import slip.grammars.Grammar ;
/* Cette classe (TreeNode) sert à construire l'arbre syntaxique d'un programme.

  Chaque instance de cette classe représente un noeud de l'arbre syntaxique.
  Alternativement, chaque instance peut être vue comme la racine d'un arbre
  syntaxique ou d'un sous-arbre syntaxique.
  
  Un noeud peut être terminal ou non terminal.
  
  S'il est terminal, il correspond à un terminal de la grammaire du langage analysé.
  Dans ce cas, 
     - le champ X est l'entier représentant le terminal de la grammaire,
     - le champ r est indéfini,
     - le champ child est égal à null,
     - le champ v est une valeur entière si le terminal X correspond aux constantes entières,
     - le champ s est un string si le terminal X correspond aux identificateurs ou à d'autres
       sortes de terminaux représentant des classes de symboles de bases (sauf les entiers)
  Si le terminal correspond à un mot-clé, un séparateur, etc., c'est-à-dire s'il n'y a qu'un
  symbole possible correspondant à ce terminal, seuls les champs X et child sont significatifs
  (child == null si et seulement si X est terminal)
      
  Si le noeud est non terminal, il correspond à une règle de la grammaire.
  Dans ce cas,
     - le champ X est l'entier correspondant à la partie gauche de la règle,
     - le champ r est l'entier donnant le numéro de la règle dans le tableau pRonde
       de la grammaire (donc, pRonde[X - NT][r] est la partie droite de la règle),
     - le champ child est un tableau de noeuds qui sont les fils de ce noeud
       et qui correspondent aux symboles de la partie droite de la règle
       (donc child.length == pRonde[X - NT][r].length),
     - le champ v est indéfini (inutilisé),
     - le champ s est indéfini (inutilisé).
     

*/
public class TreeNode{

  private int X ; // Symbol of the node
		private int r ; // rule of the node (number of the rule in pRonde[X])
		private TreeNode[] child; 
		private int v ; // integer value of the node (if any)
		private String s ; // string value of the note (if any)
		
		public TreeNode(int X)
		{ this.X = X ; }
		
			
		public TreeNode(int X, int r)
		{ this.X = X ; this.r = r ;	}
		
		public TreeNode(int X, int r, int v)
		// Terminal node with an int value
		// r is meaningless
		{ this.X = X ; this.r = r ;	this.v = v ;}
		
			public TreeNode(int X, String s)
		// Terminal node with a String value
		{ this.X = X ; this.s = s ;}
		
 	public TreeNode(int X, int r, TreeNode[] child)
		// For bottom-up parsers
		{ this(X, r) ;	putChilds(child) ;}
 
		public void putChilds(TreeNode[] child)
		// For top-down parsers
		{ this.child = child ; }
	
		public void putChilds(int r, TreeNode[] child)
		// For top-down parsers
		{ this.r = r ; this.child = child ; }
			
		public TreeNode getChild(int i){ return child[i] ; }
		public int getSymbol(){ return X ; }
		public int getRule(){ return r ; }
		
		public int getIntValue(){ return v ; }
		public String getStringValue(){ return s ; }
		public void putStringValue(String s){ this.s = s ; }
		
		public void print(Grammar g){ print("", g) ; }
		
		public void print(String s, Grammar g)
		{
			 String symbol = this.s ;
			 if (symbol == null) symbol = "" ;
			 	 else symbol = " [" + symbol + "]" ;
			 
		   System.out.println(s + g.symbol(X) + symbol) ;
		   if (child != null)
		   	 { s += "||" ;
		   	   int i = 0 ;
		   	   while (i != child.length) child[i ++].print(s, g) ;
		   	 }
		}
}
