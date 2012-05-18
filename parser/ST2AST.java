import slip.trees.TreeNode;

public class ST2AST{
  private static int trad0(TreeNode tree){
  // Tree symbol is LEX_INT

      return Integer.parseInt(tree.getStringValue()) ; // a modifier
  }
  private static String trad4(TreeNode tree){
  // Tree symbol is LEX_STR

      return tree.getStringValue() ; // a modifier
  }
  private static String trad6(TreeNode tree){
  // Tree symbol is LEX_ID

      return tree.getStringValue() ; // a modifier
  }
  private static String trad29(TreeNode tree){
  // Tree symbol is LEX_FNAME

      return tree.getStringValue() ; // a modifier
  }
  private static Statement trad44(TreeNode tree){
  // tree symbol is <program>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <program> --> <statement> 
               { 
                 Statement x0 = trad75(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Constant trad45(TreeNode tree){
  // tree symbol is <int>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <int> --> LEX_INT 
               { 
                 int x0 = trad0(tree.getChild(0)) ;
                 return new Constant(new IntValue(x0)) ; // a modifier
               }
       default : return null ;
    }
  }
  private static BooleanE trad46(TreeNode tree){
  // tree symbol is <boolean>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <boolean> --> true 
               { 
                 return new BooleanE(new BooleanValue(true)) ; // a modifier
               }
       case 1 : // <boolean> --> false 
               { 
                 return new BooleanE(new BooleanValue(false)) ; // a modifier
               }
       default : return null ;
    }
  }
  private static StringE trad47(TreeNode tree){
  // tree symbol is <string>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <string> --> " LEX_STR " 
               { 
                 String x1 = trad4(tree.getChild(1)) ;
                 return new StringE(new StringValue(x1)) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad48(TreeNode tree){
  // tree symbol is <identifier>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <identifier> --> $ <identifier0> 
               { 
                 Expression x1 = trad49(tree.getChild(1)) ;
                 return x1 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad49(TreeNode tree){
  // tree symbol is <identifier0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <identifier0> --> LEX_ID <array> 
               { 
                 String x0 = "$" + trad6(tree.getChild(0)) ;
                 Expression x1 = trad50(tree.getChild(1)) ;
		 Identifier id = new Identifier();
		 id.set(x0);
		 if (x1 == null)
		 	return id;
                 return new ArrayElement(id, x1) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad50(TreeNode tree){
  // tree symbol is <array>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <array> --> <lambda>
               { 
                 return null ; // a modifier
               }
       case 1 : // <array> --> <array_list> 
               { 
                 Expression x0 = trad51(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad51(TreeNode tree){
  // tree symbol is <array_list>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <array_list> --> [ <expression> ] <array_list0> 
               { 
                 Expression x1 = trad55(tree.getChild(1)) ;
                 Object x3 = trad52(tree.getChild(3)) ;
                 return x1 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad52(TreeNode tree){
  // tree symbol is <array_list0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <array_list0> --> <lambda>
               { 
                 return null ; // a modifier
               }
       case 1 : // <array_list0> --> <array_list> 
               { 
                 Expression x0 = trad51(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad53(TreeNode tree){
  // tree symbol is <operator>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <operator> --> + 
               { 
                 return new Addition() ; // a modifier
               }
       case 1 : // <operator> --> - 
               { 
                 return new Subtraction() ; // a modifier
               }
       case 2 : // <operator> --> * 
               { 
                 return new Multiplication() ; // a modifier
               }
       case 3 : // <operator> --> / 
               { 
                 return new Division() ; // a modifier
               }
       case 4 : // <operator> --> % 
               { 
                 return new Modulo() ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad54(TreeNode tree){
  // tree symbol is <expression0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression0> --> <int> 
               { 
                 Constant x0 = trad45(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       case 1 : // <expression0> --> <identifier> 
               { 
                 Expression x0 = trad48(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       case 2 : // <expression0> --> <string> 
               { 
                 StringE x0 = trad47(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       case 3 : // <expression0> --> <fname> ( <expression_list> ) 
               { 
                 FName x0 = trad67(tree.getChild(0)) ;
                 List<Expression> x2 = trad58(tree.getChild(2)) ;
                 return new Call(x0, x2) ; // a modifier
               }
       case 4 : // <expression0> --> ( <expression> ) 
               { 
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return x1 ; // a modifier
               }
       case 5 : // <expression0> --> <lambda_expression> 
               { 
                 Lambda x0 = trad57(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       default : return null ;
    }
  }
  private static BinaryOp trad55(TreeNode tree){
  // tree symbol is <expression>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression> --> <expression0> <expression1> 
               { 
                 Expression x0 = trad54(tree.getChild(0)) ;
                 BinaryOp x1 = trad56(tree.getChild(1)) ;
		 x1.setLeft(x0);
                 return x1 ; // a modifier
               }
       default : return null ;
    }
  }
  private static BinaryOp trad56(TreeNode tree){
  // tree symbol is <expression1>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression1> --> <lambda>
               { 
                 return null ; // a modifier
               }
       case 1 : // <expression1> --> <operator> <expression> 
               { 
                 BinaryOp x0 = trad53(tree.getChild(0)) ;
                 Expression x1 = trad55(tree.getChild(1)) ;
		 x0.setRight(x1);
                 return new x0 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Lambda trad57(TreeNode tree){
  // tree symbol is <lambda_expression>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <lambda_expression> --> lambda ( <arg0> ) { <return> } 
               { 
                 List<Identifier> x2 = trad65(tree.getChild(2)) ;
                 Return x5 = trad73(tree.getChild(5)) ;
                 return new Lambda(x5, x2) ; // a modifier
               }
       default : return null ;
    }
  }
  private static List<Expression> trad58(TreeNode tree){
  // tree symbol is <expression_list>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression_list> --> <expression> <expression_list0> 
               { 
	         List<Expression> exprs = new LinkedList<Expression>();
                 Expression x0 = trad55(tree.getChild(0)) ;
		 exprs.add(x0);
                 List<Expression> x1 = trad59(tree.getChild(1)) ;
		 if (x1 != null)
		 	exprs.addAll(x1);
                 return exprs ; // a modifier
               }
       default : return null ;
    }
  }
  private static List<Expression> trad59(TreeNode tree){
  // tree symbol is <expression_list0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression_list0> --> <lambda>
               { 
                 return null ; // a modifier
               }
       case 1 : // <expression_list0> --> , <expression_list> 
               { 
                 List<Expression> x1 = trad58(tree.getChild(1)) ;
                 return x1 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad60(TreeNode tree){
  // tree symbol is <boolean_expression>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <boolean_expression> --> <boolean> 
               { 
                 BooleanValue x0 = trad46(tree.getChild(0)) ;
                 return new BooleanE(x0) ; // a modifier
               }
       case 1 : // <boolean_expression> --> <expression> <boolean_expression0> 
               { 
                 Expression x0 = trad55(tree.getChild(0)) ;
                 BinaryOp x1 = trad61(tree.getChild(1)) ;
		 x1.setLeft(x0);
                 return x1 ; // a modifier
               }
       case 2 : // <boolean_expression> --> ! <boolean_expression> 
               { 
                 BooleanE x1 = trad60(tree.getChild(1)) ;
                 return new Not(x1) ; // a modifier
               }
       default : return null ;
    }
  }
  private static BinaryOp trad61(TreeNode tree){
  // tree symbol is <boolean_expression0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <boolean_expression0> --> <comparator> <expression> 
               { 
                 Comparator x0 = trad63(tree.getChild(0)) ;
                 Expression x1 = trad55(tree.getChild(1)) ;
		 x0.setRight(x1);
                 return x0 ; // a modifier
               }
       case 1 : // <boolean_expression0> --> <boolean_operator> <expression> 
               { 
                 BooleanOp x0 = trad64(tree.getChild(0)) ;
                 Expression x1 = trad55(tree.getChild(1)) ;
		 x0.setRight(x1);
                 return x0 ; // a modifier
               }
       case 2 : // <boolean_expression0> --> <lambda>
               { 
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static BooleanE trad62(TreeNode tree){
  // tree symbol is <condition>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <condition> --> <boolean_expression> 
               { 
                 BooleanE x0 = trad60(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       default : return null ;
    }
  }
  private static Comparator trad63(TreeNode tree){
  // tree symbol is <comparator>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <comparator> --> < 
               { 
                 return new LessThan() ; // a modifier
               }
       case 1 : // <comparator> --> > 
               { 
                 return new GreaterThan() ; // a modifier
               }
       case 2 : // <comparator> --> >= 
               { 
                 return new GreaterThanOrEquals() ; // a modifier
               }
       case 3 : // <comparator> --> <= 
               { 
                 return new LessThanOrEquals() ; // a modifier
               }
       case 4 : // <comparator> --> == 
               { 
                 return new EqualsTo() ; // a modifier
               }
       case 5 : // <comparator> --> != 
               { 
                 return new Different() ; // a modifier
               }
       default : return null ;
    }
  }
  private static BooleanOperator trad64(TreeNode tree){
  // tree symbol is <boolean_operator>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <boolean_operator> --> or 
               { 
                 return new Or() ; // a modifier
               }
       case 1 : // <boolean_operator> --> and 
               { 
                 return new And() ; // a modifier
               }
       default : return null ;
    }
  }
  private static List<Identifier> trad65(TreeNode tree){
  // tree symbol is <arg0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <arg0> --> <identifier> <arg> 
               { 
	         List<Identifier> ids = new LinkedList<Identifier>();
                 Identifier x0 = trad48(tree.getChild(0)) ;
		 ids.add(x0);
                 List<Identifier> x1 = trad66(tree.getChild(1)) ;
		 if (x1 != null)
		 	ids.addAll(x1);
                 return ids ; // a modifier
               }
       default : return null ;
    }
  }
  private static List<Identifier> trad66(TreeNode tree){
  // tree symbol is <arg>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <arg> --> <lambda>
               { 
                 return null ; // a modifier
               }
       case 1 : // <arg> --> , <arg0> 
               { 
                 List<Identifier> x1 = trad65(tree.getChild(1)) ;
                 return x1 ; // a modifier
               }
       default : return null ;
    }
  }
  private static FName trad67(TreeNode tree){
  // tree symbol is <fname>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <fname> --> LEX_FNAME 
               { 
                 String x0 = trad29(tree.getChild(0)) ;
		 FName fname = new FName();
		 fname.set(x0);
                 return fname ; // a modifier
               }
       default : return null ;
    }
  }
  private static Statement trad68(TreeNode tree){
  // tree symbol is <declaration>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <declaration> --> <identifier> <declaration0> 
               { 
                 Identifier x0 = trad48(tree.getChild(0)) ;
                 Expression x1 = trad69(tree.getChild(1)) ;
		 if (x1 == null)
		 	return new Declaration(x0);
		 else
                 	return new Assignation(x0, x1) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad69(TreeNode tree){
  // tree symbol is <declaration0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <declaration0> --> <lambda>
               { 
                 return null ; // a modifier
               }
       case 1 : // <declaration0> --> = <expression> 
               { 
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return x1 ; // a modifier
               }
       default : return null ;
    }
  }
  private static If trad70(TreeNode tree){
  // tree symbol is <if>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <if> --> if ( <condition> ) { <statement> } <if0> 
               { 
                 BooleanE x2 = trad62(tree.getChild(2)) ;
                 Statement x5 = trad75(tree.getChild(5)) ;
                 Statement x7 = trad71(tree.getChild(7)) ;
                 return new If(x2, x5, x7) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Statement trad71(TreeNode tree){
  // tree symbol is <if0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <if0> --> else { <statement> } 
               { 
                 Statement x2 = trad75(tree.getChild(2)) ;
                 return x2 ; // a modifier
               }
       case 1 : // <if0> --> <lambda>
               { 
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Function trad72(TreeNode tree){
  // tree symbol is <function>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <function> --> function <fname> ( <arg0> ) { <statement_list> <return> } 
               { 
                 FName x1 = trad67(tree.getChild(1)) ;
                 Object x3 = trad65(tree.getChild(3)) ;
                 Statement x6 = trad76(tree.getChild(6)) ;
                 Return x7 = trad73(tree.getChild(7)) ;
                 return new Function(x1, x3, new Sequence(x6, x7)) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Return trad73(TreeNode tree){
  // tree symbol is <return>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <return> --> return <expression> ; 
               { 
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return new Return(x1) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Statement trad74(TreeNode tree){
  // tree symbol is <statement0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <statement0> --> <declaration> ; 
               { 
                 Statement x0 = trad68(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       case 1 : // <statement0> --> while ( <condition> ) { <statement> } 
               { 
                 BooleanE x2 = trad62(tree.getChild(2)) ;
                 Statement x5 = trad75(tree.getChild(5)) ;
                 return new While(x2, x5) ; // a modifier
               }
       case 2 : // <statement0> --> <if> 
               { 
                 If x0 = trad70(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       case 3 : // <statement0> --> say ( <expression> ) ; 
               { 
                 Expression x2 = trad55(tree.getChild(2)) ;
                 return new Say(x2) ; // a modifier
               }
       case 4 : // <statement0> --> listen ( <identifier> ) ; 
               { 
                 Identifier x2 = trad48(tree.getChild(2)) ;
                 return new Listen(x2) ; // a modifier
               }
       case 5 : // <statement0> --> <function> 
               { 
                 Function x0 = trad72(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       case 6 : // <statement0> --> map ( <lambda_expression> , <identifier> ) ; 
               { 
                 Lambda x2 = trad57(tree.getChild(2)) ;
                 Identifier x4 = trad48(tree.getChild(4)) ;
                 return new Map(x2, x4) ; // a modifier
               }
       case 7 : // <statement0> --> read ( <identifier> ) ; 
               { 
                 Identifier x2 = trad48(tree.getChild(2)) ;
                 return new Read(x2) ; // a modifier
               }
       case 8 : // <statement0> --> write ( <identifier> ) ; 
               { 
                 Identifier x2 = trad48(tree.getChild(2)) ;
                 return new Write(x2) ; // a modifier
               }
       case 9 : // <statement0> --> size ( <identifier> , <identifier> ) ; 
               { 
                 Identifier x2 = trad48(tree.getChild(2)) ;
                 Identifier x4 = trad48(tree.getChild(4)) ;
                 return new Size(x2, x4) ; // a modifier
               }
       case 10 : // <statement0> --> array ( <identifier> , <int> ) ; 
               { 
                 Identifier x2 = trad48(tree.getChild(2)) ;
                 Constant x4 = trad45(tree.getChild(4)) ;
                 return new ArrayDeclaration(x2, new Array(x4.getValue().intValue())) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Sequence trad75(TreeNode tree){
  // tree symbol is <statement>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <statement> --> <statement0> <statement_list> 
               { 
                 Statement x0 = trad74(tree.getChild(0)) ;
                 Statment x1 = trad76(tree.getChild(1)) ;
		 if (x1 == null)
		 	return x0;
                 return new Sequence(x0, x1) ; // a modifier
               }
       default : return null ;
    }
  }
  private static Statement trad76(TreeNode tree){
  // tree symbol is <statement_list>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <statement_list> --> <lambda>
               { 
                 return null ; // a modifier
               }
       case 1 : // <statement_list> --> <statement> 
               { 
                 Statement x0 = trad75(tree.getChild(0)) ;
                 return x0 ; // a modifier
               }
       default : return null ;
    }
  }
 public static Object tradProgram(TreeNode tree) throws Exception
 { return  trad44(tree) ; }

}
