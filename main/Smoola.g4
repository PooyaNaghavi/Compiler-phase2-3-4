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
    program:
        main_class = mainClass {Program syn_program = new Program(); syn_program.setMainClass($main_class.syn_main_class); }
        (class_dec = classDeclaration {syn_program.addClass($class_dec.syn_class_declaration); })*
        {
          SymbolTable.push(new SymbolTable());
          SymbolTable.error = false;
          SymbolTable.has_error = true;
          SymbolTable.path1_error = false;
          SymbolTable.path2_error = true;
          SymbolTable.path3_error = true;
          SymbolTable.path4_error = true;
        }
        EOF
        {
          Visitor visitor = new VisitorImpl();
          syn_program.accept(visitor);
          SymbolTable.path1_error = true;
          SymbolTable.path2_error = false;
          syn_program.accept(visitor);
          SymbolTable.path2_error = true;
          SymbolTable.path3_error = false;
          syn_program.accept(visitor);
          SymbolTable.path3_error = true;
          SymbolTable.path4_error = false;
          //syn_program.accept(visitor);
          Visitor_path4 path4 = new Visitor_path4();
          syn_program.accept(path4);
          SymbolTable.path4_error = true;
          if(SymbolTable.error == false){
              SymbolTable.has_error = false;
          }
          if(SymbolTable.has_error == false)
            syn_program.accept(visitor);
          else{
              HashMap<Integer, String> errors = visitor.getErrors();
              ArrayList<Integer> keys = new ArrayList(errors.keySet());
              Collections.sort(keys);
              for (Integer i : keys) {
                  System.out.println("Line:" + i + errors.get(i));
              }
          }
        }
    ;
    mainClass returns[ClassDeclaration syn_main_class]:
        // name should be checked later
        'class' class_name = ID {ClassDeclaration main_class = new ClassDeclaration(new Identifier($class_name.text)); main_class.set_line_num($class_name.getLine());}
        '{' 'def' method_name = ID '(' ')' ':' 'int' {MethodDeclaration method_dec = new MethodDeclaration(new Identifier($method_name.text)); method_dec.set_line_num($method_name.getLine());}
        {method_dec.setReturnType(new IntType()); }
        '{'  stms = statements {method_dec.addStatements($stms.syn_statements); }
        'return' return_exp = expression {method_dec.setReturnValue($return_exp.syn_expression); } ';' '}' '}'
        {main_class.addMethodDeclaration(method_dec); $syn_main_class = main_class;}
    ;
    classDeclaration returns[ClassDeclaration syn_class_declaration]:
        'class' class_name = ID {ClassDeclaration class_dec = new ClassDeclaration(new Identifier($class_name.text)); class_dec.set_line_num($class_name.getLine());}('extends' parent_class_name = ID {class_dec.setParentName(new Identifier($parent_class_name.text)); class_dec.set_line_num($parent_class_name.getLine()); })?
        '{' (var_dec = varDeclaration {class_dec.addVarDeclaration($var_dec.syn_var_declaration); })*
        (method_dec = methodDeclaration {class_dec.addMethodDeclaration($method_dec.syn_method_declaration); })* '}'
        {$syn_class_declaration = class_dec; }
    ;
    varDeclaration returns[VarDeclaration syn_var_declaration]:
        'var' var_name = ID ':' var_type = type ';' {$syn_var_declaration = new VarDeclaration(new Identifier($var_name.text), $var_type.syn_type); $syn_var_declaration.set_line_num($var_name.getLine());}
    ;
    methodDeclaration returns[MethodDeclaration syn_method_declaration]:
        'def' method_name = ID {MethodDeclaration method_dec = new MethodDeclaration(new Identifier($method_name.text)); method_dec.set_line_num($method_name.getLine()); } ('(' ')'
        |
        ('(' var_name1 = ID ':' var_type1 = type {VarDeclaration var1 = new VarDeclaration(new Identifier($var_name1.text), $var_type1.syn_type); method_dec.addArg(var1); var1.set_line_num($var_name1.getLine());}
        (',' var_name2 = ID ':' var_type2 = type {VarDeclaration var2 = new VarDeclaration(new Identifier($var_name2.text), $var_type2.syn_type); method_dec.addArg(var2); var2.set_line_num($var_name2.getLine());} )* ')'))
        ':' return_type = type {method_dec.setReturnType($return_type.syn_type); }
        '{' (var_dec = varDeclaration {method_dec.addLocalVar($var_dec.syn_var_declaration); })*
        stms = statements {method_dec.addStatements($stms.syn_statements); }
        'return' return_exp = expression {method_dec.setReturnValue($return_exp.syn_expression); $syn_method_declaration = method_dec; }';' '}'
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
        'if' '(' exp = expression')' 'then' stm1 = statement ('else' stm2 = statement)? {$syn_statement_condition = new Conditional($exp.syn_expression, $stm1.syn_statement, $stm2.syn_statement);}
    ;
    statementLoop returns[While syn_statement_loop]:
        'while' '(' exp = expression ')' stm = statement {$syn_statement_loop = new While($exp.syn_expression, $stm.syn_statement);}
    ;
    statementWrite returns[Write syn_statement_write]:
        'writeln(' exp = expression {$syn_statement_write = new Write($exp.syn_expression);}')' ';'
    ;
    statementAssignment returns[Assign syn_statement_assign]:
        exp = expression
        {
          if($exp.syn_expression == null)
              $syn_statement_assign = $exp.syn_expression_assign;
        } ';'
    ;
    expression returns[Assign syn_expression_assign, Expression syn_expression]:

		  exp_assign = expressionAssignment
      {
        if($exp_assign.syn_assign_right == null)
            $syn_expression = $exp_assign.syn_expression_assignment;
        else
            $syn_expression_assign = new Assign($exp_assign.syn_assign_left, $exp_assign.syn_assign_right);
      }
	  ;

    expressionAssignment returns[Expression syn_assign_left, Expression syn_assign_right, Expression syn_expression_assignment, String syn_assign_op]:
		  exp_or = expressionOr assign_op = '=' exp_assign = expressionAssignment
      {
          {
              $syn_assign_op = $assign_op.text;
              $syn_assign_left = $exp_or.syn_expression_or;
              $syn_assign_right = $exp_assign.syn_expression_assignment;
              $syn_expression_assignment = new BinaryExpression($exp_or.syn_expression_or, $exp_assign.syn_expression_assignment, BinaryOperator.assign);
          }
      }
	    |	exp_or = expressionOr
      {$syn_expression_assignment = $exp_or.syn_expression_or; }
	  ;

    expressionOr returns[Expression syn_expression_or]:
  		exp_and = expressionAnd exp_or_temp = expressionOrTemp
      {

        if($exp_or_temp.syn_expression_or_temp == null)
            $syn_expression_or = $exp_and.syn_expression_and;
        else
            $syn_expression_or = new BinaryExpression($exp_and.syn_expression_and, $exp_or_temp.syn_expression_or_temp, BinaryOperator.or);

        }
  	;

    expressionOrTemp returns[Expression syn_expression_or_temp, String syn_or_op]:
  		or_op = '||' exp_and = expressionAnd exp_or_temp = expressionOrTemp
      {
            if($exp_or_temp.syn_expression_or_temp == null) {
                $syn_expression_or_temp = $exp_and.syn_expression_and;
                $syn_or_op = $or_op.text;
            }
            else {
                $syn_or_op = $or_op.text;
                $syn_expression_or_temp = new BinaryExpression($exp_and.syn_expression_and, $exp_or_temp.syn_expression_or_temp, BinaryOperator.or );
            }
        }
  	    |
    ;
    expressionAnd returns[Expression syn_expression_and]:
  		exp_eq = expressionEq exp_and_temp =expressionAndTemp
      {
        if($exp_and_temp.syn_expression_and_temp == null)
            $syn_expression_and = $exp_eq.syn_expression_eq;
        else
            $syn_expression_and = new BinaryExpression($exp_eq.syn_expression_eq, $exp_and_temp.syn_expression_and_temp, BinaryOperator.and);
      }
  	;
    expressionAndTemp returns[Expression syn_expression_and_temp, String syn_and_op]:
  		and_op = '&&' exp_eq = expressionEq exp_and_temp = expressionAndTemp
      {
          if($exp_and_temp.syn_expression_and_temp == null)
          {
              $syn_expression_and_temp = $exp_eq.syn_expression_eq;
              $syn_and_op = $and_op.text;
          }
          else
          {
              $syn_and_op = $and_op.text;
              $syn_expression_and_temp = new BinaryExpression($exp_eq.syn_expression_eq, $exp_and_temp.syn_expression_and_temp, BinaryOperator.and );
          }
      }
  	  |
  	;
    expressionEq returns[Expression syn_expression_eq]:
  		exp_cmp = expressionCmp exp_eq_temp = expressionEqTemp
      {
       if($exp_eq_temp.syn_expression_eq_temp == null)
          $syn_expression_eq = $exp_cmp.syn_expression_cmp;
      else {
           if($exp_eq_temp.syn_eq_op.equals("=="))
               $syn_expression_eq = new BinaryExpression($exp_cmp.syn_expression_cmp, $exp_eq_temp.syn_expression_eq_temp, BinaryOperator.eq);
           else if($exp_eq_temp.syn_eq_op.equals("<>"))
               $syn_expression_eq = new BinaryExpression($exp_cmp.syn_expression_cmp, $exp_eq_temp.syn_expression_eq_temp, BinaryOperator.neq);
       }
     }
  	;

    expressionEqTemp returns[Expression syn_expression_eq_temp, String syn_eq_op]:
  		op_eq = ('==' | '<>') exp_cmp = expressionCmp exp_eq_temp = expressionEqTemp
      {
          if($exp_eq_temp.syn_expression_eq_temp == null) {
              $syn_expression_eq_temp = $exp_cmp.syn_expression_cmp;
              $syn_eq_op = $op_eq.text;
              /* if($op_eq.text.equals(BinaryOperator.eq))
                  $syn_eq_op = BinaryOperator.eq;
              else if($op_eq.text.equals(BinaryOperator.neq))
                  $syn_eq_op = BinaryOperator.neq; */
          }
          else {
              $syn_eq_op = $op_eq.text;
              if($exp_eq_temp.syn_eq_op.equals("==")){
              //if($op_eq.text.equals(BinaryOperator.eq)){
                  //$syn_eq_op = BinaryOperator.eq;
                  $syn_expression_eq_temp = new BinaryExpression($exp_cmp.syn_expression_cmp, $exp_eq_temp.syn_expression_eq_temp, BinaryOperator.eq );
              }
              else if($exp_eq_temp.syn_eq_op.equals("<>")){
              //else if($op_eq.text.equals(BinaryOperator.neq)){
                //  $syn_eq_op = BinaryOperator.neq;
                  $syn_expression_eq_temp = new BinaryExpression($exp_cmp.syn_expression_cmp, $exp_eq_temp.syn_expression_eq_temp, BinaryOperator.neq );
              }
          }
      }
  	  |
  	;

    expressionCmp returns[Expression syn_expression_cmp]:
  		exp_add = expressionAdd exp_cmp_temp = expressionCmpTemp
      {
        if($exp_cmp_temp.syn_expression_cmp_temp == null)
            $syn_expression_cmp = $exp_add.syn_expression_add;
        else {
            if($exp_cmp_temp.syn_cmp_op.equals(">"))
                $syn_expression_cmp = new BinaryExpression($exp_add.syn_expression_add, $exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.gt);
            else if($exp_cmp_temp.syn_cmp_op.equals("<"))
                $syn_expression_cmp = new BinaryExpression($exp_add.syn_expression_add, $exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.lt);
        }
      }
  	;

    expressionCmpTemp returns[Expression syn_expression_cmp_temp, String syn_cmp_op]:
  		op_cmp = ('<' | '>') exp_add = expressionAdd exp_cmp_temp = expressionCmpTemp
      {
          if($exp_cmp_temp.syn_expression_cmp_temp == null) {
              $syn_expression_cmp_temp = $exp_add.syn_expression_add;
              $syn_cmp_op = $op_cmp.text;
              /* if($op_cmp.text.equals(BinaryOperator.gt))
                  $syn_cmp_op = BinaryOperator.gt;
              else if($op_cmp.text.equals(BinaryOperator.lt))
                  $syn_cmp_op = BinaryOperator.lt; */
          }
          else {
                $syn_cmp_op = $op_cmp.text;
                if($exp_cmp_temp.syn_cmp_op.equals(">")){
              //if($op_cmp.text.equals(BinaryOperator.gt)){
                  //$syn_cmp_op = BinaryOperator.gt;
                  $syn_expression_cmp_temp = new BinaryExpression($exp_add.syn_expression_add, $exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.gt );
              }
              else if($exp_cmp_temp.syn_cmp_op.equals("<")){
              //else if($op_cmp.text.equals(BinaryOperator.lt)){
                  //$syn_cmp_op = BinaryOperator.lt;
                  $syn_expression_cmp_temp = new BinaryExpression($exp_add.syn_expression_add, $exp_cmp_temp.syn_expression_cmp_temp, BinaryOperator.lt );
              }
          }
      }
  	  |
  /* {System.out.println("asfkajsflkjlaksfj");} */


  	;

    expressionAdd returns[Expression syn_expression_add]:
  		exp_mult = expressionMult exp_add_temp = expressionAddTemp
      {
          if($exp_add_temp.syn_expression_add_temp == null)
                $syn_expression_add = $exp_mult.syn_expression_mult;
          else {
              if($exp_add_temp.syn_add_op.equals("+"))
                  $syn_expression_add = new BinaryExpression($exp_mult.syn_expression_mult, $exp_add_temp.syn_expression_add_temp, BinaryOperator.add);
              else if($exp_add_temp.syn_add_op.equals("-"))
                  $syn_expression_add = new BinaryExpression($exp_mult.syn_expression_mult, $exp_add_temp.syn_expression_add_temp, BinaryOperator.sub);
          }
      }
  	;

    expressionAddTemp returns[Expression syn_expression_add_temp, String syn_add_op]:
  		op_add = ('+' | '-') exp_mult = expressionMult exp_temp_add = expressionAddTemp
      {
          if($exp_temp_add.syn_expression_add_temp == null) {
              $syn_expression_add_temp = $exp_mult.syn_expression_mult;
              $syn_add_op = $op_add.text;
              /* if($op_add.text.equals(BinaryOperator.add))
                  $syn_add_op = BinaryOperator.add;
              else if($op_add.text.equals(BinaryOperator.sub))
                  $syn_add_op = BinaryOperator.sub; */
          }
          else {
              $syn_add_op = $op_add.text;
              if($exp_temp_add.syn_add_op.equals("+")){
              //if($op_add.text.equals(BinaryOperator.add)){
                  //$syn_add_op = BinaryOperator.add;
                  $syn_expression_add_temp = new BinaryExpression($exp_mult.syn_expression_mult, $exp_temp_add.syn_expression_add_temp, BinaryOperator.add);
              }
              else if($exp_temp_add.syn_add_op.equals("-")){
              //else if($op_add.text.equals(BinaryOperator.sub)){
                  //$syn_add_op = BinaryOperator.sub;
                  $syn_expression_add_temp = new BinaryExpression($exp_mult.syn_expression_mult, $exp_temp_add.syn_expression_add_temp, BinaryOperator.sub);
              }
          }
      }
  	  |
  	;

    expressionMult returns[Expression syn_expression_mult]:

  		exp_unary = expressionUnary exp_mult_temp = expressionMultTemp
      {
        if($exp_mult_temp.syn_expression_mult_temp == null)
            $syn_expression_mult = $exp_unary.syn_expression_unary;
        else {
          if($exp_mult_temp.syn_mult_op.equals("*"))
              $syn_expression_mult = new BinaryExpression($exp_unary.syn_expression_unary, $exp_mult_temp.syn_expression_mult_temp, BinaryOperator.mult );
          else if($exp_mult_temp.syn_mult_op.equals("/"))
              $syn_expression_mult = new BinaryExpression($exp_unary.syn_expression_unary, $exp_mult_temp.syn_expression_mult_temp, BinaryOperator.div );
        }
      }
  	;
    expressionMultTemp returns[Expression syn_expression_mult_temp, String syn_mult_op]:
  		op_mult = ('*' | '/') exp_unary = expressionUnary exp_mult_temp = expressionMultTemp
      {
          if($exp_mult_temp.syn_expression_mult_temp == null) {
              $syn_expression_mult_temp = $exp_unary.syn_expression_unary;
              $syn_mult_op = $op_mult.text;
          }
          else {
              $syn_mult_op = $op_mult.text;
              if($exp_mult_temp.syn_mult_op.equals("*")){
              //if($op_mult.text.equals(BinaryOperator.mult)){
                  //$syn_mult_op = BinaryOperator.mult;
                  $syn_expression_mult_temp = new BinaryExpression($exp_unary.syn_expression_unary, $exp_mult_temp.syn_expression_mult_temp, BinaryOperator.mult);

              }
              else if($exp_mult_temp.syn_mult_op.equals("/")){
              //else if($op_mult.text.equals(BinaryOperator.div)){
                //  $syn_mult_op = BinaryOperator.div;
                  $syn_expression_mult_temp = new BinaryExpression($exp_unary.syn_expression_unary, $exp_mult_temp.syn_expression_mult_temp, BinaryOperator.div);
              }
          }
      }
  	  |
  	;

    expressionUnary returns[Expression syn_expression_unary]:
  		op_unary = ('!' | '-') exp_unary = expressionUnary
      {
        if($op_unary.text.equals("!"))
            $syn_expression_unary = new UnaryExpression(UnaryOperator.not, $exp_unary.syn_expression_unary);
        else if($op_unary.text.equals("-"))
            $syn_expression_unary = new UnaryExpression(UnaryOperator.minus, $exp_unary.syn_expression_unary);
      }
  	  |	exp_mem = expressionMem
      {$syn_expression_unary = $exp_mem.syn_expression_mem; }
  	;

    expressionMem returns[Expression syn_expression_mem]:
  		exp_method = expressionMethods exp_mem_temp = expressionMemTemp

      {
        if($exp_mem_temp.syn_expression_mem_temp == null)
            $syn_expression_mem = $exp_method.syn_expression_method;
        else
            $syn_expression_mem = new ArrayCall($exp_method.syn_expression_method, $exp_mem_temp.syn_expression_mem_temp);
      }
  	;

    expressionMemTemp returns[Expression syn_expression_mem_temp]:
  		'[' exp = expression ']'
        {$syn_expression_mem_temp = $exp.syn_expression; }
  	   |
  	;

  	expressionMethods returns[Expression syn_expression_method]:
  	    exp_other = expressionOther exp_method_temp = expressionMethodsTemp[$exp_other.syn_expression_other]
          // inherited for not null ?!
        {
          if($exp_method_temp.syn_expression_method_temp == null)
            $syn_expression_method = $exp_other.syn_expression_other;
          else
            $syn_expression_method = $exp_method_temp.syn_expression_method_temp;
        }
  	;
    // ????????????
  	expressionMethodsTemp [Expression inh_expression_other] returns[Expression syn_expression_method_temp]:

  	    '.' (method_name1 = ID '(' ')'
        {$syn_expression_method_temp = new MethodCall($inh_expression_other, new Identifier($method_name1.text)); $syn_expression_method_temp.set_line_num($method_name1.getLine());}
        | method_name2 = ID {MethodCall method_call = new MethodCall($inh_expression_other, new Identifier($method_name2.text)); method_call.set_line_num($method_name2.getLine());}
        '(' (exp_arg1 = expression {method_call.addArg($exp_arg1.syn_expression); }(',' exp_arg2 = expression {method_call.addArg($exp_arg2.syn_expression); })*) ')' { $syn_expression_method_temp = method_call; }
        | 'length' {$syn_expression_method_temp = new Length($inh_expression_other); } )
        exp_method_temp = expressionMethodsTemp[$syn_expression_method_temp]
        { $syn_expression_method_temp = $exp_method_temp.syn_expression_method_temp; }
  	    | { $syn_expression_method_temp = $inh_expression_other;}
  	;
    expressionOther returns[Expression syn_expression_other]:
  	    const_num = CONST_NUM
        {$syn_expression_other = new IntValue($const_num.int, new IntType()); }
        |	const_str = CONST_STR
        {$syn_expression_other = new StringValue($const_str.text, new StringType()); }
        |   'new ' 'int' '[' const_num = CONST_NUM ']'
        {$syn_expression_other = new NewArray($const_num.int); $syn_expression_other.set_line_num($const_num.getLine());}
        |   'new ' class_name = ID '(' ')'
        {$syn_expression_other = new NewClass(new Identifier($class_name.text)); $syn_expression_other.set_line_num($class_name.getLine());}
        |   'this'
        {$syn_expression_other = new This();}
        |   'true'
        {$syn_expression_other = new BooleanValue(true, new BooleanType()); }
        |   'false'
        {$syn_expression_other = new BooleanValue(false, new BooleanType()); }
        | identifier = ID
        {$syn_expression_other = new Identifier($identifier.text); $syn_expression_other.set_line_num($identifier.getLine()); }
        |   array_name = ID '[' array_index = expression ']'
        {$syn_expression_other = new ArrayCall(new Identifier($array_name.text), $array_index.syn_expression); $syn_expression_other.set_line_num($array_name.getLine());}
        |	'(' expr = expression ')'
        {$syn_expression_other = $expr.syn_expression; }
  	;
  	type returns[Type syn_type]:
  	    khar = 'int'
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
        {$syn_type = new UserDefinedType(new Identifier($class_name.text));}
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
