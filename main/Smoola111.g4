grammar Smoola;
@header{
    import ast.*;
    import ast.node.*;
    import ast.node.expression.*;
    import ast.node.expression.Value.*;
    import ast.Type.*;
    import ast.Type.PrimitiveType.*;
    import ast.node.statement.*;
    import ast.node.declaration.*;
    import ast.node.expression.*;
    import ast.Type.ArrayType.*;
    import ast.Type.PrimitiveType.*;
    import ast.Type.UserDefinedType.*;
    import ast.node.expression.MethodCall;
    import symbolTable.*;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Collections;
}
@members{
//    void add_arg_to_method(MethodDeclaration md, VarDeclaration vd){
//      md.addArg(vd);
//    }
//    void add_else_to_if(Conditional c, Statement alt_st){
//      c.setAlternativeBody(alt_st);
//    }

}
    program :
        m_cls = mainClass {Program prg = new Program(); prg.setMainClass($m_cls.main_dec);} (cls = classDeclaration {prg.addClass($cls.cls_dec);})*
        {
            SymbolTable.push(new SymbolTable());
            SymbolTable.index = 0;

            SymbolTable.first_traverse = false;
            SymbolTable.hasError = false;
            Visitor visitor = new VisitorImpl();
            Visitor visitor1 = new VisitorPath1();
            Visitor visitor2 = new VisitorPath2();
            Visitor visitor3 = new VisitorPath3();
            Visitor visitor4 = new VisitorPath4();
            Visitor visitorprint = new VisitorPathPrint();
            prg.accept(visitor1);
            SymbolTable.first_traverse = true;
            prg.accept(visitor2);
            SymbolTable.second_traverse = true;
            prg.accept(visitor3);
            SymbolTable.third_traverse = true;
//            prg.accept(visitor);

//            if(SymbolTable.hasError == false )
                prg.accept(visitor4);
            if(SymbolTable.hasError == false )
                prg.accept(visitorprint);
            HashMap<Integer, String> errs = visitor.getErrs();
            ArrayList <Integer> keys = new ArrayList(errs.keySet());
            Collections.sort(keys);
            for(int i=0;i<keys.size();i++){
                System.out.println("Line:"+keys.get(i)+errs.get(keys.get(i)));
            }

        }EOF

    ;
    mainClass returns [ClassDeclaration main_dec]:
           // name should be checked later
           'class' name = ID {$main_dec = new ClassDeclaration(new Identifier($name.text, $name.getLine())); $main_dec.setLineNum($name.getLine()); }
           '{' 'def' met_name = ID {MethodDeclaration met_dec = new MethodDeclaration(new Identifier($met_name.text, $met_name.getLine())); met_dec.setLineNum($met_name.getLine()); }'(' ')'
           ':' t = 'int' {met_dec.setReturnType(new IntType()); $main_dec.addMethodDeclaration(met_dec);}
           '{'  stmnts = statements {met_dec.addStatements($stmnts.syn_sts);} 'return' e1 = expression {met_dec.setReturnValue($e1.expr);} ';' '}' '}'
       ;
       classDeclaration returns [ClassDeclaration cls_dec]:
           'class' name = ID{$cls_dec = new ClassDeclaration (new Identifier($name.text, $name.getLine()), null);$cls_dec.setLineNum($name.getLine());}  ('extends' parent = ID {$cls_dec.setParentName(new Identifier($parent.text,$parent.getLine())); $cls_dec.setLineNum($name.getLine());})?

           '{' (vd = varDeclaration {$cls_dec.addVarDeclaration($vd.var_dec);})* (md = methodDeclaration {$cls_dec.addMethodDeclaration($md.met_dec);})* '}'
       ;
       varDeclaration returns [VarDeclaration var_dec]:
           'var' name = ID ':' t = type ';'
           {    $var_dec = new VarDeclaration (new Identifier($name.text, $name.getLine()) , $t.syn_type);
                $var_dec.setLineNum($name.getLine());
           }
       ;
       methodDeclaration returns [MethodDeclaration met_dec]:
           'def' name = ID {$met_dec = new MethodDeclaration(new Identifier($name.text, $name.getLine())); $met_dec.setLineNum($name.getLine());}
           ('(' ')'
           | ('(' name1 = ID ':' t1= type {$met_dec.addArg(new VarDeclaration(new Identifier($name1.text, $name.getLine()), $t1.syn_type,$name1.getLine())); } (',' name2 = ID  ':' t2 = type {$met_dec.addArg(new VarDeclaration(new Identifier($name2.text, $name2.getLine()), $t2.syn_type, $name2.getLine()));} )* ')'))
            ':' t3 = type {$met_dec.setReturnType($t3.syn_type);}'{'  (vd = varDeclaration {$met_dec.addLocalVar($vd.var_dec);})* stmnts = statements {$met_dec.addStatements($stmnts.syn_sts);} 'return' e1 = expression {$met_dec.setReturnValue($e1.expr);} ';' '}'
       ;
       statements returns [ ArrayList <Statement> syn_sts ]:
           {$syn_sts = new ArrayList <Statement> ();}
           (st = statement {$syn_sts.add($st.syn_st);})*
       ;
       statement returns [Statement syn_st ]:
           sb = statementBlock {$syn_st = $sb.syn_sb; }|
           sc = statementCondition {$syn_st = $sc.syn_sc;} |
           sl = statementLoop {$syn_st = $sl.syn_sl;}|
           sw = statementWrite {$syn_st = $sw.syn_sw;} |
           sa = statementAssignment {$syn_st = $sa.syn_sa;}
       ;
       statementBlock returns [Block syn_sb]:
           '{'  s1 = statements { $syn_sb = new Block(); $syn_sb.addStatements($s1.syn_sts); }  '}'
       ;
       statementCondition returns [Conditional syn_sc]:
           'if' '('e1 = expression')' 'then' s1 = statement {$syn_sc = new Conditional($e1.expr, $s1.syn_st,null);} ('else' s2 = statement {$syn_sc.setAlternativeBody($s2.syn_st);})? //QQQQ
       ;
       statementLoop returns [While syn_sl]:
           'while' '(' e1 = expression ')' s1 = statement {$syn_sl = new While($e1.expr, $s1.syn_st);}
       ;
       statementWrite returns [Write syn_sw]:
           'writeln(' e1 = expression {$syn_sw = new Write($e1.expr);} ')' ';'
       ;
       statementAssignment returns [Assign syn_sa]:
           e1 = expression { if($e1.expr == null) $syn_sa = $e1.exp_ass;}';'
       ;


       expression returns[Expression expr, Assign  exp_ass] :
       expr_assign = expressionAssignment
       {
         if($expr_assign.syn_right == null){
           $expr = $expr_assign.syn_exprassign;
         }
         else
           {
               $exp_ass = new Assign($expr_assign.syn_left, $expr_assign.syn_right);
           }
       }
     ;

       expressionAssignment returns[Expression syn_exprassign, String syn_expr_op_assign,Expression syn_left,Expression syn_right]:
        expr_or = expressionOr op_ass = '=' expr_ass = expressionAssignment
           {

                   $syn_expr_op_assign = $op_ass.text;
                   $syn_exprassign = new BinaryExpression($expr_or.syn_expror, $expr_ass.syn_exprassign, BinaryOperator.assign);
                   $syn_left = $expr_or.syn_expror ;
                   $syn_right = $expr_ass.syn_exprassign ;


           }
         |  expr_or = expressionOr
           {
               $syn_exprassign = $expr_or.syn_expror;
           }

     ;

       expressionOr returns[Expression syn_expror]:
       expr_and = expressionAnd expr_or = expressionOrTemp
         {
           if($expr_or.syn_expror != null)
                   $syn_expror = new BinaryExpression($expr_and.syn_exprand, $expr_or.syn_expror, BinaryOperator.or);
           else
               $syn_expror = $expr_and.syn_exprand;

       }
     ;

       expressionOrTemp returns[Expression syn_expror, String syn_expr_op_or] :
       op_or = '||' expr_and = expressionAnd expr_or = expressionOrTemp
         {
               if($expr_or.syn_expror == null)
               {
                   $syn_expror = $expr_and.syn_exprand;
                   $syn_expr_op_or = $op_or.text;
               }
               else
               {
                   $syn_expr_op_or = $op_or.text;
                   $syn_expror = new BinaryExpression($expr_and.syn_exprand, $expr_or.syn_expror, BinaryOperator.or );
               }
           }
         |
     ;

       expressionAnd returns[Expression syn_exprand]:
       expr_eq = expressionEq expr_and = expressionAndTemp
         {
           if($expr_and.syn_exprand != null)
                   $syn_exprand = new BinaryExpression($expr_eq.syn_expreq, $expr_and.syn_exprand, BinaryOperator.and);
           else
               $syn_exprand = $expr_eq.syn_expreq;

       }
     ;

       expressionAndTemp returns[Expression syn_exprand, String syn_expr_op_and]:
        op_and = '&&' expr_eq = expressionEq expr_and = expressionAndTemp
           {
               if($expr_and.syn_exprand == null)
               {
                   $syn_exprand = $expr_eq.syn_expreq;
                   $syn_expr_op_and = $op_and.text;
               }
               else
               {
                   $syn_expr_op_and = $op_and.text;
                   $syn_exprand = new BinaryExpression($expr_eq.syn_expreq, $expr_and.syn_exprand, BinaryOperator.and );
               }
           }
         |
     ;

       expressionEq returns[Expression syn_expreq]:
       expr_cmp = expressionCmp expr_eq = expressionEqTemp
          {
           if($expr_eq.syn_expreq != null)
           {
               if($expr_eq.syn_expr_op_eq.equals("=="))
                   $syn_expreq = new BinaryExpression($expr_cmp.syn_exprcmp, $expr_eq.syn_expreq, BinaryOperator.eq);
               if($expr_eq.syn_expr_op_eq.equals("<>"))
                   $syn_expreq = new BinaryExpression($expr_cmp.syn_exprcmp, $expr_eq.syn_expreq, BinaryOperator.neq);
           }
           else
               $syn_expreq = $expr_cmp.syn_exprcmp;

       }
     ;

       expressionEqTemp returns[Expression syn_expreq, String syn_expr_op_eq]:
       op_eq = ('==' | '<>') expr_cmp = expressionCmp expr_eq = expressionEqTemp
           {
               if($expr_eq.syn_expreq == null)
               {
                   $syn_expreq = $expr_cmp.syn_exprcmp;
                   $syn_expr_op_eq = $op_eq.text;
               }
               else
               {
                   $syn_expr_op_eq = $op_eq.text;
                   if($expr_eq.syn_expr_op_eq.equals("=="))
                       $syn_expreq = new BinaryExpression($expr_cmp.syn_exprcmp, $expr_eq.syn_expreq, BinaryOperator.eq );
                   else if($expr_eq.syn_expr_op_eq.equals("<>"))
                       $syn_expreq = new BinaryExpression($expr_cmp.syn_exprcmp, $expr_eq.syn_expreq, BinaryOperator.neq );
               }
           }
         |
     ;

       expressionCmp returns[Expression syn_exprcmp]:
       expr_add = expressionAdd expr_cmp = expressionCmpTemp
         {
           if($expr_cmp.syn_exprcmp != null)
           {
               if($expr_cmp.syn_expr_op_cmp.equals(">"))
                   $syn_exprcmp = new BinaryExpression($expr_add.syn_expradd, $expr_cmp.syn_exprcmp, BinaryOperator.gt);
               if($expr_cmp.syn_expr_op_cmp.equals("<"))
                   $syn_exprcmp = new BinaryExpression($expr_add.syn_expradd, $expr_cmp.syn_exprcmp, BinaryOperator.lt);
           }
           else
               $syn_exprcmp = $expr_add.syn_expradd;

       }
     ;

       expressionCmpTemp returns[Expression syn_exprcmp, String syn_expr_op_cmp]:
       op_cmp = ('<' | '>') expr_add = expressionAdd expr_cmp = expressionCmpTemp
           {
               if($expr_cmp.syn_exprcmp == null)
               {
                   $syn_exprcmp = $expr_add.syn_expradd;
                   $syn_expr_op_cmp = $op_cmp.text;
               }
               else
               {
                   $syn_expr_op_cmp = $op_cmp.text;
                   if($expr_cmp.syn_expr_op_cmp.equals(">"))
                       $syn_exprcmp = new BinaryExpression($expr_add.syn_expradd, $expr_cmp.syn_exprcmp, BinaryOperator.gt );
                   else if($expr_cmp.syn_expr_op_cmp.equals("<"))
                       $syn_exprcmp = new BinaryExpression($expr_add.syn_expradd, $expr_cmp.syn_exprcmp, BinaryOperator.lt );
               }
           }
         |
     ;

       expressionAdd returns[Expression syn_expradd]:
       expr_mult = expressionMult expr_add = expressionAddTemp
       {
           if($expr_add.syn_expradd != null)
           {
               if($expr_add.syn_expr_op_add.equals("+"))
                   $syn_expradd = new BinaryExpression($expr_mult.syn_exprmult, $expr_add.syn_expradd, BinaryOperator.add);
               if($expr_add.syn_expr_op_add.equals("-"))
                   $syn_expradd = new BinaryExpression($expr_mult.syn_exprmult, $expr_add.syn_expradd, BinaryOperator.sub);
           }
           else
               $syn_expradd = $expr_mult.syn_exprmult;

       }
     ;

       expressionAddTemp  returns[Expression syn_expradd, String syn_expr_op_add ] :
       op_add = ('+' | '-') expr_mult = expressionMult expr_add = expressionAddTemp
           {
               if($expr_add.syn_expr_op_add == null)
               {
                   $syn_expradd = $expr_mult.syn_exprmult;
                   $syn_expr_op_add = $op_add.text;
               }
               else
               {
                   $syn_expr_op_add = $op_add.text;
                   if($expr_add.syn_expr_op_add.equals("+"))
                       $syn_expradd = new BinaryExpression($expr_mult.syn_exprmult, $expr_add.syn_expradd, BinaryOperator.add );
                   else if($expr_add.syn_expr_op_add.equals("-"))
                       $syn_expradd = new BinaryExpression($expr_mult.syn_exprmult, $expr_add.syn_expradd, BinaryOperator.sub );
               }
           }

         |
     ;

       expressionMult returns[Expression syn_exprmult]:
       expr_unary = expressionUnary expr_mult = expressionMultTemp
       {
           if($expr_mult.syn_exprmult != null)
           {
               if($expr_mult.syn_expr_op_mult.equals( "*"))
                   $syn_exprmult = new BinaryExpression($expr_unary.syn_exprunary, $expr_mult.syn_exprmult, BinaryOperator.mult );
               else if($expr_mult.syn_expr_op_mult.equals("/"))
                   $syn_exprmult = new BinaryExpression($expr_unary.syn_exprunary, $expr_mult.syn_exprmult, BinaryOperator.div );
           }
           else
               $syn_exprmult = $expr_unary.syn_exprunary;

       }
     ;

       expressionMultTemp returns[Expression syn_exprmult, String syn_expr_op_mult ]:
       op_mult = ('*' | '/') expr_unary = expressionUnary  expr_mult = expressionMultTemp
           {
               if($expr_mult.syn_exprmult == null)
               {
                   $syn_exprmult = $expr_unary.syn_exprunary;
                   $syn_expr_op_mult = $op_mult.text;
               }
               else
               {
                   $syn_expr_op_mult = $op_mult.text;
                   if($expr_mult.syn_expr_op_mult.equals( "*"))
                       $syn_exprmult = new BinaryExpression($expr_unary.syn_exprunary, $expr_mult.syn_exprmult, BinaryOperator.mult );
                   else if($expr_mult.syn_expr_op_mult.equals( "/"))
                       $syn_exprmult = new BinaryExpression($expr_unary.syn_exprunary, $expr_mult.syn_exprmult, BinaryOperator.div );
               }
           }

         |

     ;

       expressionUnary returns[Expression syn_exprunary]:
       op_unary = ('!' | '-') expr_un = expressionUnary
           {
               if($op_unary.text.equals( "!"))
                   $syn_exprunary = new UnaryExpression(UnaryOperator.not, $expr_un.syn_exprunary);
               else if($op_unary.text.equals( "-"))
                   $syn_exprunary = new UnaryExpression(UnaryOperator.minus, $expr_un.syn_exprunary);

           }
         |  expr_mem = expressionMem
           { $syn_exprunary = $expr_mem.syn_exprmem;}
     ;

       expressionMem returns[Expression syn_exprmem]:
       expr_meth = expressionMethods expr_mem = expressionMemTemp
       {
           if($expr_mem.syn_exprmem != null)
               $syn_exprmem = new ArrayCall($expr_meth.syn_exprmethod, $expr_mem.syn_exprmem);
           else
               $syn_exprmem = $expr_meth.syn_exprmethod;
       }
     ;

       expressionMemTemp returns[Expression syn_exprmem]:
       name = '[' exp = expression ']'
           { $syn_exprmem = $exp.expr;
             $syn_exprmem.setLineNum($name.getLine());}
         |

     ;


     expressionMethods returns[Expression syn_exprmethod]:
               exp_other = expressionOther exp_method_temp = expressionMethodsTemp[$exp_other.expr]
               {
                 if($exp_method_temp.syn_expr_method == null)
                   $syn_exprmethod = $exp_other.expr;
                 else
                   $syn_exprmethod = $exp_method_temp.syn_expr_method;
               }
           ;
           expressionMethodsTemp [Expression inh_expr_other] returns[Expression syn_expr_method]:

               '.' (method_name1 = ID '(' ')'
               {$syn_expr_method = new MethodCall($inh_expr_other, new Identifier($method_name1.text, $method_name1.getLine())); $syn_expr_method.setLineNum($method_name1.getLine()); }
               | method_name2 = ID {MethodCall method_call = new MethodCall($inh_expr_other, new Identifier($method_name2.text, $method_name2.getLine()));method_call.setLineNum($method_name2.getLine());}
               '(' (exp_arg1 = expression {method_call.addArg($exp_arg1.expr); }(',' exp_arg2 = expression {method_call.addArg($exp_arg2.expr); })*) ')' { $syn_expr_method = method_call; }
               | 'length' {$syn_expr_method = new Length($inh_expr_other); } )
               exp_method_temp = expressionMethodsTemp[$syn_expr_method]
               { $syn_expr_method = $exp_method_temp.syn_expr_method; }
               | { $syn_expr_method = $inh_expr_other;}
           ;
       expressionOther returns[Expression expr]:
       cnum = CONST_NUM
           { $expr = new IntValue($cnum.int, new IntType());$expr.setLineNum($cnum.getLine());}
           |  cstr = CONST_STR
               { $expr = new StringValue($cstr.text, new StringType());$expr.setLineNum($cstr.getLine());}
           |   'new ' 'int' '[' cnum = CONST_NUM ']'
           {
               //$expr = new NewArray(new IntValue($cnum.int, new IntType()));
               $expr = new NewArray($cnum.int);
               $expr.setLineNum($cnum.getLine());
           }
           |   'new ' name = ID '(' ')'
               {
                   Identifier classname = new Identifier($name.text, $name.getLine());
                   $expr = new NewClass(classname);
                   $expr.setLineNum($name.getLine());
               }
           |   name = 'this'
               { $expr = new This(); $expr.setLineNum($name.getLine());} //TODO: Must efine constructor
           |   name = 'true'
               { $expr = new BooleanValue(true, new BooleanType());$expr.setLineNum($name.getLine());}
           |   name = 'false'
               { $expr = new BooleanValue(false, new BooleanType());
                 $expr.setLineNum($name.getLine());}
           |  name = ID
               { $expr= new Identifier($name.text, $name.getLine());
                 $expr.setLineNum($name.getLine());}
           |   name = ID '[' index = expression ']'
               {

                   Expression array_name = new Identifier($name.text, $name.getLine());
                   $expr = new ArrayCall(array_name, $index.expr);
                   $expr.setLineNum($name.getLine());


               }
           |  name = '(' exp = expression ')'
               { $expr = $exp.expr;
                $expr.setLineNum($name.getLine());}
     ;

     type returns [Type syn_type]:
         'int' {$syn_type = new IntType();} |
         'boolean' {$syn_type = new BooleanType();}|
         'string' {$syn_type = new StringType();}|
         'int' '[' ']' {$syn_type = new ArrayType(); }|
         name = ID {$syn_type = new UserDefinedType( new Identifier($name.text, $name.getLine()));} /// define name
     ;
       CONST_NUM:
       [0-9]+
     ;

       CONST_STR:
       '"' ~('\r' | '\n' | '"')* '"'
     ;
       NL:
       '\r'? '\n' -> skip
     ;

       ID:
       [a-zA-Z_][a-zA-Z0-9_]*
     ;

       COMMENT:
       '#'(~[\r\n])* -> skip
     ;

       WS:
         [ \t] -> skip
       ;

