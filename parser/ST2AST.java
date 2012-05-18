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

      return "$" + tree.getStringValue() ; // a modifier
  }
  private static String trad29(TreeNode tree){
  // Tree symbol is LEX_FNAME

      return tree.getStringValue() ; // a modifier
  }
  private static Object trad44(TreeNode tree){
  // tree symbol is <program>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <program> --> <statement> 
               { 
                 Object x0 = trad75(tree.getChild(0)) ;
                 return null ; // a modifier
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
  private static Identifier trad48(TreeNode tree){
  // tree symbol is <identifier>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <identifier> --> $ <identifier0> 
               { 
                 Object x1 = trad49(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad49(TreeNode tree){
  // tree symbol is <identifier0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <identifier0> --> LEX_ID <array> 
               { 
                 String x0 = trad6(tree.getChild(0)) ;
                 Object x1 = trad50(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad50(TreeNode tree){
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
                 Object x0 = trad51(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad51(TreeNode tree){
  // tree symbol is <array_list>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <array_list> --> [ <expression> ] <array_list0> 
               { 
                 Expression x1 = trad55(tree.getChild(1)) ;
                 Object x3 = trad52(tree.getChild(3)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad52(TreeNode tree){
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
                 Object x0 = trad51(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad53(TreeNode tree){
  // tree symbol is <operator>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <operator> --> + 
               { 
                 return null ; // a modifier
               }
       case 1 : // <operator> --> - 
               { 
                 return null ; // a modifier
               }
       case 2 : // <operator> --> * 
               { 
                 return null ; // a modifier
               }
       case 3 : // <operator> --> / 
               { 
                 return null ; // a modifier
               }
       case 4 : // <operator> --> % 
               { 
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad54(TreeNode tree){
  // tree symbol is <expression0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression0> --> <int> 
               { 
                 Constant x0 = trad45(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       case 1 : // <expression0> --> <identifier> 
               { 
                 Object x0 = trad48(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       case 2 : // <expression0> --> <string> 
               { 
                 StringE x0 = trad47(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       case 3 : // <expression0> --> <fname> ( <expression_list> ) 
               { 
                 FName x0 = trad67(tree.getChild(0)) ;
                 Object x2 = trad58(tree.getChild(2)) ;
                 return null ; // a modifier
               }
       case 4 : // <expression0> --> ( <expression> ) 
               { 
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       case 5 : // <expression0> --> <lambda_expression> 
               { 
                 Lambda x0 = trad57(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Expression trad55(TreeNode tree){
  // tree symbol is <expression>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression> --> <expression0> <expression1> 
               { 
                 Object x0 = trad54(tree.getChild(0)) ;
                 Object x1 = trad56(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad56(TreeNode tree){
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
                 Object x0 = trad53(tree.getChild(0)) ;
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return null ; // a modifier
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
                 Object x2 = trad65(tree.getChild(2)) ;
                 Object x5 = trad73(tree.getChild(5)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad58(TreeNode tree){
  // tree symbol is <expression_list>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <expression_list> --> <expression> <expression_list0> 
               { 
                 Expression x0 = trad55(tree.getChild(0)) ;
                 Object x1 = trad59(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad59(TreeNode tree){
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
                 Object x1 = trad58(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static BooleanE trad60(TreeNode tree){
  // tree symbol is <boolean_expression>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <boolean_expression> --> <boolean> 
               { 
                 Object x0 = trad46(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       case 1 : // <boolean_expression> --> <expression> <boolean_expression0> 
               { 
                 Expression x0 = trad55(tree.getChild(0)) ;
                 Object x1 = trad61(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       case 2 : // <boolean_expression> --> ! <boolean_expression> 
               { 
                 BooleanE x1 = trad60(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad61(TreeNode tree){
  // tree symbol is <boolean_expression0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <boolean_expression0> --> <comparator> <expression> 
               { 
                 Object x0 = trad63(tree.getChild(0)) ;
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       case 1 : // <boolean_expression0> --> <boolean_operator> <expression> 
               { 
                 Object x0 = trad64(tree.getChild(0)) ;
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       case 2 : // <boolean_expression0> --> <lambda>
               { 
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad62(TreeNode tree){
  // tree symbol is <condition>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <condition> --> <boolean_expression> 
               { 
                 BooleanE x0 = trad60(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad63(TreeNode tree){
  // tree symbol is <comparator>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <comparator> --> < 
               { 
                 return null ; // a modifier
               }
       case 1 : // <comparator> --> > 
               { 
                 return null ; // a modifier
               }
       case 2 : // <comparator> --> >= 
               { 
                 return null ; // a modifier
               }
       case 3 : // <comparator> --> <= 
               { 
                 return null ; // a modifier
               }
       case 4 : // <comparator> --> == 
               { 
                 return null ; // a modifier
               }
       case 5 : // <comparator> --> != 
               { 
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad64(TreeNode tree){
  // tree symbol is <boolean_operator>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <boolean_operator> --> or 
               { 
                 return null ; // a modifier
               }
       case 1 : // <boolean_operator> --> and 
               { 
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad65(TreeNode tree){
  // tree symbol is <arg0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <arg0> --> <identifier> <arg> 
               { 
                 Object x0 = trad48(tree.getChild(0)) ;
                 Object x1 = trad66(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad66(TreeNode tree){
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
                 Object x1 = trad65(tree.getChild(1)) ;
                 return null ; // a modifier
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
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad68(TreeNode tree){
  // tree symbol is <declaration>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <declaration> --> <identifier> <declaration0> 
               { 
                 Object x0 = trad48(tree.getChild(0)) ;
                 Object x1 = trad69(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad69(TreeNode tree){
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
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad70(TreeNode tree){
  // tree symbol is <if>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <if> --> if ( <condition> ) { <statement> } <if0> 
               { 
                 Object x2 = trad62(tree.getChild(2)) ;
                 Object x5 = trad75(tree.getChild(5)) ;
                 Object x7 = trad71(tree.getChild(7)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad71(TreeNode tree){
  // tree symbol is <if0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <if0> --> else { <statement> } 
               { 
                 Object x2 = trad75(tree.getChild(2)) ;
                 return null ; // a modifier
               }
       case 1 : // <if0> --> <lambda>
               { 
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad72(TreeNode tree){
  // tree symbol is <function>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <function> --> function <fname> ( <arg> ) { <statement_list> <return> } 
               { 
                 FName x1 = trad67(tree.getChild(1)) ;
                 Object x3 = trad66(tree.getChild(3)) ;
                 Object x6 = trad76(tree.getChild(6)) ;
                 Object x7 = trad73(tree.getChild(7)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad73(TreeNode tree){
  // tree symbol is <return>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <return> --> return <expression> ; 
               { 
                 Expression x1 = trad55(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad74(TreeNode tree){
  // tree symbol is <statement0>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <statement0> --> <declaration> ; 
               { 
                 Object x0 = trad68(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       case 1 : // <statement0> --> while ( <condition> ) { <statement> } 
               { 
                 Object x2 = trad62(tree.getChild(2)) ;
                 Object x5 = trad75(tree.getChild(5)) ;
                 return null ; // a modifier
               }
       case 2 : // <statement0> --> <if> 
               { 
                 Object x0 = trad70(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       case 3 : // <statement0> --> say ( <expression> ) ; 
               { 
                 Expression x2 = trad55(tree.getChild(2)) ;
                 return null ; // a modifier
               }
       case 4 : // <statement0> --> listen ( <identifier> ) ; 
               { 
                 Object x2 = trad48(tree.getChild(2)) ;
                 return null ; // a modifier
               }
       case 5 : // <statement0> --> <function> 
               { 
                 Object x0 = trad72(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       case 6 : // <statement0> --> map ( <lambda_expression> , <identifier> ) ; 
               { 
                 Lambda x2 = trad57(tree.getChild(2)) ;
                 Object x4 = trad48(tree.getChild(4)) ;
                 return null ; // a modifier
               }
       case 7 : // <statement0> --> read ( <identifier> ) ; 
               { 
                 Object x2 = trad48(tree.getChild(2)) ;
                 return null ; // a modifier
               }
       case 8 : // <statement0> --> write ( <identifier> ) ; 
               { 
                 Object x2 = trad48(tree.getChild(2)) ;
                 return null ; // a modifier
               }
       case 9 : // <statement0> --> size ( <identifier> , <identifier> ) ; 
               { 
                 Object x2 = trad48(tree.getChild(2)) ;
                 Object x4 = trad48(tree.getChild(4)) ;
                 return null ; // a modifier
               }
       case 10 : // <statement0> --> array ( <identifier> , <int> ) ; 
               { 
                 Object x2 = trad48(tree.getChild(2)) ;
                 Constant x4 = trad45(tree.getChild(4)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad75(TreeNode tree){
  // tree symbol is <statement>

    int r = tree.getRule() ;
    switch (r)
    {
       case 0 : // <statement> --> <statement0> <statement_list> 
               { 
                 Object x0 = trad74(tree.getChild(0)) ;
                 Object x1 = trad76(tree.getChild(1)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
  private static Object trad76(TreeNode tree){
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
                 Object x0 = trad75(tree.getChild(0)) ;
                 return null ; // a modifier
               }
       default : return null ;
    }
  }
 public static Object tradProgram(TreeNode tree) throws Exception
 { return  trad44(tree) ; }

}
