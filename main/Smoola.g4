grammar Smoola;

@header{
    import ast.*;
    import ast.node.*;
    import ast.node.declaration.*;
    import ast.node.expression.*;
    import ast.node.statement.*;
    import ast.node.expression.Value.*;
    import ast.Type.*;
    import ast.Type.ArrayType.*;
    import ast.Type.PrimitiveType.*;
    import ast.Type.UserDefinedType.*;
    import symbolTable.*;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.HashMap;

}
@members{
    int global_line = 0;
    Expression expression_method_temp;
}
    program returns[Program p]:
        main_class = mainClass {Program syn_program = new Program(); syn_program.setMainClass($main_class.syn_main_class);}
        (class_dec = classDeclaration {syn_program.addClass($class_dec.syn_class_declaration); })*
        { $p = syn_program; }
        EOF { }
    ;
    mainClass returns[ClassDeclaration syn_main_class]:
        // name should be checked later
        class_index = 'class' class_name = ID {ClassDeclaration main_class = new ClassDeclaration(new Identifier($class_name.text, $class_name.getLine())); main_class.set_line_num($class_name.getLine());}
        '{' 'def' method_name = ID '(' ')' ':' 'int' {MethodDeclaration method_dec = new MethodDeclaration(new Identifier($method_name.text, $method_name.getLine())); method_dec.set_line_num($method_name.getLine());}
        {method_dec.setReturnType(new IntType()); }
        '{'  stms = statements {method_dec.addStatements($stms.syn_statements); }
        return_name = 'return' return_exp = expression {method_dec.setReturnValue($return_exp.syn_expression); method_dec.set_line_num($class_index.getLine());} ';' '}' '}'
        {main_class.addMethodDeclaration(method_dec); $syn_main_class = main_class;}
    ;
    classDeclaration returns[ClassDeclaration syn_class_declaration]:
        'class' class_name = ID {ClassDeclaration class_dec = new ClassDeclaration(new Identifier($class_name.text, $class_name.getLine())); class_dec.set_line_num($class_name.getLine());}('extends' parent_class_name = ID {class_dec.setParentName(new Identifier($parent_class_name.text, $parent_class_name.getLine())); class_dec.set_line_num($parent_class_name.getLine()); })?
        '{' (var_dec = varDeclaration {class_dec.addVarDeclaration($var_dec.syn_var_declaration); })*
        (method_dec = methodDeclaration {class_dec.addMethodDeclaration($method_dec.syn_method_declaration); })* '}'
        {$syn_class_declaration = class_dec; }
    ;
    varDeclaration returns[VarDeclaration syn_var_declaration]:
        'var' var_name = ID ':' var_type = type ';' {$syn_var_declaration = new VarDeclaration(new Identifier($var_name.text, $var_name.getLine()), $var_type.syn_type); $syn_var_declaration.set_line_num($var_name.getLine());}
    ;
    methodDeclaration returns[MethodDeclaration syn_method_declaration]:
        def_name = 'def' method_name = ID {MethodDeclaration method_dec = new MethodDeclaration(new Identifier($method_name.text, $method_name.getLine())); method_dec.set_line_num($method_name.getLine()); } ('(' ')'
        |
        ('(' var_name1 = ID ':' var_type1 = type {VarDeclaration var1 = new VarDeclaration(new Identifier($var_name1.text, $var_name1.getLine()), $var_type1.syn_type); method_dec.addArg(var1); var1.set_line_num($var_name1.getLine());}
        (',' var_name2 = ID ':' var_type2 = type {VarDeclaration var2 = new VarDeclaration(new Identifier($var_name2.text, $var_name2.getLine()), $var_type2.syn_type); method_dec.addArg(var2); var2.set_line_num($var_name2.getLine());} )* ')'))
        ':' return_type = type {method_dec.setReturnType($return_type.syn_type); }
        '{' (var_dec = varDeclaration {method_dec.addLocalVar($var_dec.syn_var_declaration); })*
        stms = statements {method_dec.addStatements($stms.syn_statements); }
        return_name = 'return' return_exp = expression {method_dec.setReturnValue($return_exp.syn_expression); method_dec.set_line_num($def_name.getLine()); $syn_method_declaration = method_dec; }';' '}'
    ;
    statements returns[ArrayList<Statement> syn_statements]:
        {$syn_statements = new ArrayList<Statement>();}
        (stm = statement {$syn_statements.add($stm.syn_statement); })*
    ;
    statement returns[Statement syn_statement]:
        stm_block = statementBlock {$syn_statement = $stm_block.syn_statement_block;}
        |
        stm_condition = statementCondition {$syn_statement = $stm_condition.syn_statement_condition;}
        |
        stm_loop = statementLoop {$syn_statement = $stm_loop.syn_statement_loop;}
        |
        stm_write = statementWrite {$syn_statement = $stm_write.syn_statement_write;}
        |
        stm_assignment = statementAssignment {$syn_statement = $stm_assignment.syn_statement_assign;}
    ;
    statementBlock returns[Block syn_statement_block]:
        '{'  stms = statements '}' {$syn_statement_block = new Block($stms.syn_statements);}
    ;
    statementCondition returns[Conditional syn_statement_condition]:
        if_name = 'if' '(' exp = expression')' 'then' stm1 = statement {$syn_statement_condition = new Conditional($exp.syn_expression, $stm1.syn_statement); }('else' stm2 = statement {$syn_statement_condition.setAlternativeBody($stm2.syn_statement);})? {$syn_statement_condition.set_line_num($if_name.getLine());}
    ;
    statementLoop returns[While syn_statement_loop]:
        while_name = 'while' '(' exp = expression ')' stm = statement {$syn_statement_loop = new While($exp.syn_expression, $stm.syn_statement); $syn_statement_loop.set_line_num($while_name.getLine());}
    ;
    statementWrite returns[Write syn_statement_write]:
       write_name = 'writeln(' exp = expression {Write w = new Write($exp.syn_expression); w.set_line_num($write_name.getLine()); $syn_statement_write = w;}')' ';'
    ;
    statementAssignment returns[Assign syn_statement_assign]:
        exp = expression
        {
            $syn_statement_assign = $exp.syn_expression_assign;
        } ';'
    ;
    expression returns[Assign syn_expression_assign, Expression syn_expression]:

	  exp_assign = expressionAssignment
      {

        if($exp_assign.syn_assign_right == null){
            $syn_expression = $exp_assign.syn_expression_assignment;
            //if($syn_expression instanceof BinaryExpression || $syn_expression instanceof MethodCall || $syn_expression instanceof NewClass || $syn_expression instanceof Length){
                $syn_expression_assign = new Assign(null, $exp_assign.syn_expression_assignment, $exp_assign.line);
            //}
        }
        else {
            $syn_expression_assign = new Assign($exp_assign.syn_assign_left, $exp_assign.syn_assign_right, $exp_assign.line);
            $syn_expression = $exp_assign.syn_expression_assignment;
         }
      }
	  ;

    expressionAssignment returns[Expression syn_assign_left, Expression syn_assign_right, Expression syn_expression_assignment, String syn_assign_op, Integer line]:
		exp_or = expressionOr assign_op = '=' exp_assign = expressionAssignment
        {
          $syn_assign_op = $assign_op.text;
          $syn_assign_left = $exp_or.syn_expression_or;
          $syn_assign_right = $exp_assign.syn_expression_assignment;
          $syn_expression_assignment = new BinaryExpression($exp_or.syn_expression_or, $exp_assign.syn_expression_assignment, BinaryOperator.assign);
          $line = $assign_op.getLine();
          $syn_expression_assignment.set_line_num($assign_op.getLine());
        }
	    |	exp_or = expressionOr
        {
             $syn_expression_assignment = $exp_or.syn_expression_or;
             $syn_assign_right = null;
             $syn_assign_left = null;
             $line = global_line;
        }
	  ;

    expressionOr returns[Expression syn_expression_or]:
  		exp_and = expressionAnd exp_or_temp = expressionOrTemp[$exp_and.syn_expression_and]
        {
            $syn_expression_or = $exp_or_temp.syn_expression_or_temp;
        }
  	;

    expressionOrTemp[Expression inh_expression_or] returns[Expression syn_expression_or_temp, String syn_or_op]:
  		or_op = '||' exp_and = expressionAnd
  		{
  		    BinaryExpression realorExpr = new BinaryExpression( $inh_expression_or , $exp_and.syn_expression_and , BinaryOperator.or );
  		}
  		exp_or_temp = expressionOrTemp[realorExpr]
        {
            $syn_expression_or_temp = $exp_or_temp.syn_expression_or_temp;
            $syn_expression_or_temp.set_line_num($or_op.getLine());
            global_line = $or_op.getLine();
        }
  	    |{$syn_expression_or_temp = inh_expression_or;}
    ;
    expressionAnd returns[Expression syn_expression_and]:
  	   exp_eq = expressionEq exp_and_temp =expressionAndTemp[$exp_eq.syn_expression_eq]
      {
        $syn_expression_and = $exp_and_temp.syn_expression_and_temp;
      }
  	;
    expressionAndTemp[Expression inh_expression_and] returns[Expression syn_expression_and_temp, String syn_and_op]:
  		and_op = '&&' exp_eq = expressionEq
        {
            BinaryExpression realandExpr = new BinaryExpression( $inh_expression_and , $exp_eq.syn_expression_eq , BinaryOperator.and );
        }
  		exp_and_temp = expressionAndTemp[realandExpr]
        {
          $syn_expression_and_temp = $exp_and_temp.syn_expression_and_temp;
          $syn_expression_and_temp.set_line_num($and_op.getLine());
          global_line = $and_op.getLine();

      }
  	  |{$syn_expression_and_temp = inh_expression_and;}
  	;
    expressionEq returns[Expression syn_expression_eq]:
  		exp_cmp = expressionCmp exp_eq_temp = expressionEqTemp[$exp_cmp.syn_expression_cmp]
      {
           $syn_expression_eq = $exp_eq_temp.syn_expression_eq_temp;
      }
  	;

    expressionEqTemp[Expression inh_expression_eq] returns[Expression syn_expression_eq_temp, String syn_eq_op]:
  		op_eq = ('==' | '<>') exp_cmp = expressionCmp
  		{
  		    BinaryOperator cmpBinOp = BinaryOperator.eq;
  		    if( $op_eq.text.equals( "==" ))
                cmpBinOp = BinaryOperator.eq;
            else if( $op_eq.text.equals( "<>" ))
                cmpBinOp = BinaryOperator.neq;
            BinaryExpression realeqExpr = new BinaryExpression( $inh_expression_eq , $exp_cmp.syn_expression_cmp ,  cmpBinOp );
  		}
  		exp_eq_temp = expressionEqTemp[realeqExpr]
        {
          $syn_expression_eq_temp = $exp_eq_temp.syn_expression_eq_temp;
          $syn_expression_eq_temp.set_line_num($op_eq.getLine());
          global_line = $op_eq.getLine();

      }
  	  | {$syn_expression_eq_temp = $inh_expression_eq;}
  	;

    expressionCmp returns[Expression syn_expression_cmp]:
  	exp_add = expressionAdd exp_cmp_temp = expressionCmpTemp[$exp_add.syn_expression_add]
      {
        $syn_expression_cmp = $exp_cmp_temp.syn_expression_cmp_temp;
      }
  	;

    expressionCmpTemp[Expression inh_expression_cmp] returns[Expression syn_expression_cmp_temp, String syn_cmp_op]:
  		op_cmp = ('<' | '>') exp_add = expressionAdd
  		{
  		    BinaryOperator cmpBinOp = BinaryOperator.gt;
            if( $op_cmp.text.equals( ">" ) )
                cmpBinOp = BinaryOperator.gt;
            else if( $op_cmp.text.equals( "<" ) )
                cmpBinOp = BinaryOperator.lt;

             BinaryExpression realcmpExpr = new BinaryExpression( $inh_expression_cmp , $exp_add.syn_expression_add ,  cmpBinOp );
  		}
  	    exp_cmp_temp = expressionCmpTemp[realcmpExpr]
        {

          $syn_expression_cmp_temp = $exp_cmp_temp.syn_expression_cmp_temp;
          $syn_expression_cmp_temp.set_line_num($op_cmp.getLine());
          global_line = $op_cmp.getLine();
        }
  	  | {$syn_expression_cmp_temp = $inh_expression_cmp;}

  	;

    expressionAdd returns[Expression syn_expression_add]:
  		exp_mult = expressionMult exp_add_temp = expressionAddTemp[$exp_mult.syn_expression_mult]
      {
          $syn_expression_add = $exp_add_temp.syn_expression_add_temp;
      }
  	;

    expressionAddTemp[Expression inh_expression_add] returns[Expression syn_expression_add_temp, String syn_add_op]:
  		op_add = ('+' | '-') exp_mult = expressionMult
  		{
  		    BinaryOperator addBinOp = BinaryOperator.add;
  		    if( $op_add.text.equals( "+" ) )
                addBinOp = BinaryOperator.add;
            else if( $op_add.text.equals( "-" ) )
                addBinOp = BinaryOperator.sub;

             BinaryExpression realaddExpr = new BinaryExpression( $inh_expression_add , $exp_mult.syn_expression_mult ,  addBinOp );
  		}

  		exp_temp_add = expressionAddTemp[realaddExpr]
        {
          $syn_expression_add_temp = $exp_temp_add.syn_expression_add_temp;
          $syn_expression_add_temp.set_line_num($op_add.getLine());
          global_line = $op_add.getLine();
        }
  	  | {$syn_expression_add_temp = $inh_expression_add;}
  	;
    expressionMult returns[Expression syn_expression_mult]:

  		exp_unary = expressionUnary exp_mult_temp = expressionMultTemp[$exp_unary.syn_expression_unary]
      {
         $syn_expression_mult = $exp_mult_temp.syn_expression_mult_temp;
      }
  	;

    expressionMultTemp [Expression inh_expressiopn_mult] returns[Expression syn_expression_mult_temp, String syn_mult_op]:
  		op_mult = ('*' | '/') exp_unary = expressionUnary
  		 {

           //$syn_expression_mult_temp = $exp_unary.syn_expression_unary;
           BinaryOperator multBinOp = BinaryOperator.mult;
           if( $op_mult.text.equals( "*" ) )
               multBinOp = BinaryOperator.mult;
           else if( $op_mult.text.equals( "/" ) )
               multBinOp = BinaryOperator.div;
           BinaryExpression realMultExpr = new BinaryExpression( $inh_expressiopn_mult , $exp_unary.syn_expression_unary ,  multBinOp );
           $syn_mult_op = $op_mult.text;

  	     }

  		 exp_mult_temp = expressionMultTemp[realMultExpr]
         {
               $syn_expression_mult_temp = $exp_mult_temp.syn_expression_mult_temp;
               $syn_expression_mult_temp.set_line_num($op_mult.getLine());
                           global_line = $op_mult.getLine();
         }

  	  | {$syn_expression_mult_temp = $inh_expressiopn_mult;}

  	;

    expressionUnary returns[Expression syn_expression_unary]:
  		op_unary = ('!' | '-') exp_unary = expressionUnary
        {
        if($op_unary.text.equals("!")){
            $syn_expression_unary = new UnaryExpression(UnaryOperator.not, $exp_unary.syn_expression_unary);
            $syn_expression_unary.set_line_num($op_unary.getLine());
        }
        else if($op_unary.text.equals("-")){
            $syn_expression_unary = new UnaryExpression(UnaryOperator.minus, $exp_unary.syn_expression_unary);
            $syn_expression_unary.set_line_num($op_unary.getLine());
        }
      }
  	  |	exp_mem = expressionMem
      {$syn_expression_unary = $exp_mem.syn_expression_mem; }
  	;

    expressionMem returns[Expression syn_expression_mem]:
  		exp_method = expressionMethods exp_mem_temp = expressionMemTemp
      {
        if($exp_mem_temp.syn_expression_mem_temp == null)
            $syn_expression_mem = $exp_method.syn_expression_method;
        else{
            $syn_expression_mem = new ArrayCall($exp_method.syn_expression_method, $exp_mem_temp.syn_expression_mem_temp, $exp_mem_temp.line);
           }
      }
  	;

    expressionMemTemp returns[Expression syn_expression_mem_temp, int line]:
  		bracket = '[' exp = expression ']'
        {$syn_expression_mem_temp = $exp.syn_expression;
         $syn_expression_mem_temp.set_line_num($bracket.getLine());
         $line = $bracket.getLine();
         }
  	   |
  	;

  	expressionMethods returns[Expression syn_expression_method]:
  	    exp_other = expressionOther exp_method_temp = expressionMethodsTemp[$exp_other.syn_expression_other]
        {
          if($exp_method_temp.syn_expression_method_temp == null)
            $syn_expression_method = $exp_other.syn_expression_other;
          else{
            $syn_expression_method = $exp_method_temp.syn_expression_method_temp;
           }
        }
  	;

  	expressionMethodsTemp [Expression inh_expression_other] returns[Expression syn_expression_method_temp]:

  	    '.' (method_name1 = ID '(' ')'
            {MethodCall method_call = new MethodCall($inh_expression_other, new Identifier($method_name1.text, $method_name1.getLine())); method_call.set_line_num($method_name1.getLine()); expression_method_temp = method_call;}
            | method_name2 = ID {MethodCall method_call = new MethodCall($inh_expression_other, new Identifier($method_name2.text, $method_name2.getLine())); method_call.set_line_num($method_name2.getLine());}
            '(' (exp_arg1 = expression {method_call.addArg($exp_arg1.syn_expression); }(',' exp_arg2 = expression {method_call.addArg($exp_arg2.syn_expression); })*) ')' {expression_method_temp = method_call;}
            | len = 'length' {Length len = new Length($inh_expression_other); len.set_line_num($len.getLine()); expression_method_temp = len;}
        )
        exp_method_temp = expressionMethodsTemp[expression_method_temp]
        {
            $syn_expression_method_temp = $exp_method_temp.syn_expression_method_temp;
        }
  	    | { $syn_expression_method_temp = $inh_expression_other;}
  	;
    expressionOther returns[Expression syn_expression_other]:
  	    const_num = CONST_NUM
        {$syn_expression_other = new IntValue($const_num.int, new IntType()); $syn_expression_other.set_line_num($const_num.getLine()); }
        |	const_str = CONST_STR
        {$syn_expression_other = new StringValue($const_str.text, new StringType()); $syn_expression_other.set_line_num($const_str.getLine()); }
        |   const_str = 'new ' 'int' '[' const_num = CONST_NUM ']'
        {$syn_expression_other = new NewArray($const_num.int); $syn_expression_other.set_line_num($const_num.getLine());}
        |   new_id = 'new ' class_name = ID '(' ')'
        {$syn_expression_other = new NewClass(new Identifier($class_name.text, $class_name.getLine())); $syn_expression_other.set_line_num($class_name.getLine()); global_line = $new_id.getLine();}
        |   pointer_str = 'this'
        {$syn_expression_other = new This(); $syn_expression_other.set_line_num($pointer_str.getLine());}
        |   bool_str = 'true'
        {$syn_expression_other = new BooleanValue(true, new BooleanType()); $syn_expression_other.set_line_num($bool_str.getLine()); }
        |   bool_str = 'false'
        {$syn_expression_other = new BooleanValue(false, new BooleanType()); $syn_expression_other.set_line_num($bool_str.getLine()); }
        |   identifier = ID
        {$syn_expression_other = new Identifier($identifier.text, $identifier.getLine()); $syn_expression_other.set_line_num($identifier.getLine()); }
        |   array_name = ID '[' array_index = expression ']'
        {$syn_expression_other = new ArrayCall(new Identifier($array_name.text, $array_name.getLine()), $array_index.syn_expression); $syn_expression_other.set_line_num($array_name.getLine());}
        |	lpar = '(' expr = expression ')'
        {$syn_expression_other = $expr.syn_expression; $syn_expression_other.set_line_num($lpar.getLine()); }
  	;
  	type returns[Type syn_type]:
  	    'int'
        {$syn_type = new IntType(); }
        |
  	    'boolean'
        {$syn_type = new BooleanType(); }
        |
  	    'string'
        {$syn_type = new StringType(); }
        |
  	    'int' '[' ']'
        {$syn_type = new ArrayType();}
        |
  	    class_name = ID
        {
            $syn_type = new UserDefinedType(new Identifier($class_name.text, $class_name.getLine()));
        }
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
