package ast;
//import ast.VisitorImpl;
import ast.Type.ArrayType.ArrayType;
import ast.Type.NoType;
import ast.Type.PrimitiveType.BooleanType;
import ast.Type.PrimitiveType.IntType;
import ast.Type.PrimitiveType.StringType;
import ast.Type.Type;
import ast.Type.UserDefinedType.UserDefinedType;
import ast.node.Program;
import ast.node.declaration.ClassDeclaration;
import ast.node.declaration.MethodDeclaration;
import ast.node.declaration.VarDeclaration;
import ast.node.expression.*;
import ast.node.expression.Value.BooleanValue;
import ast.node.expression.Value.IntValue;
import ast.node.expression.Value.StringValue;
import ast.node.statement.*;
import symbolTable.*;

import java.util.ArrayList;

public class Visitor_path4 extends VisitorImpl{
    public SymbolTable symbolTable_top;
    public String line_number;

    public boolean check_parent_Type(String left ,String right){
        if(left == null || right==null ) {
            return false;
        }
        else if(left.equals(right) || left.equals("#Class_"+right) )
            return true;

        SymbolTable parent_symbolTable =symbol_table_items.get(left).getPre();
        if(parent_symbolTable == null )
            return false;
        for ( String key : symbol_table_items.keySet() ) {
            if(symbol_table_items.get(key) == parent_symbolTable){
                return check_parent_Type(key,right);
            }
        }
        return check_parent_Type(left,right);
    }

    public Type unary_subType(Type expression, UnaryOperator op){
        if(op.equals(UnaryOperator.minus)) {
            if(!(expression instanceof IntType || expression instanceof NoType)){
                SymbolTable.error = true;
                add_error(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                //errors.put(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                return new NoType();
            }else{
                return new IntType();
            }
        }else if(op.equals(UnaryOperator.not)) {
            if(!(expression instanceof BooleanType || expression instanceof NoType)){
                SymbolTable.error = true;
                add_error(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                //errors.put(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                return new NoType();
            }else{
                return new BooleanType();
            }
        }
        return  new NoType();
    }

    public Type binary_subType(Type left_expression_type, Type right_expression_type, BinaryOperator op){
        if(op.equals(BinaryOperator.eq) || op.equals(BinaryOperator.neq)) {
            if(left_expression_type instanceof BooleanType || right_expression_type instanceof BooleanType){
                SymbolTable.error = true;
                add_error(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                //errors.put(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                return new NoType();
            }else if(!((left_expression_type instanceof  NoType || right_expression_type instanceof NoType) ||
                    ((left_expression_type.toString().equals(right_expression_type.toString())) &&
                    (left_expression_type instanceof IntType || left_expression_type instanceof ArrayType ||
                            left_expression_type instanceof StringType || left_expression_type instanceof UserDefinedType)))) {
                SymbolTable.error = true;
                add_error(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                //errors.put(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                return new NoType();
            }else if(left_expression_type instanceof UserDefinedType && right_expression_type instanceof UserDefinedType) {
                if (((UserDefinedType) left_expression_type).getClassDeclaration().getParentName() != null) {
                    if (check_parent_Type(((UserDefinedType) left_expression_type).getClassDeclaration().getParentName().getName(), ((UserDefinedType) right_expression_type).getClassDeclaration().getName().getName()))
                        return new BooleanType();
                    else
                        return new NoType();
                }else if (((UserDefinedType) right_expression_type).getClassDeclaration().getParentName() != null)
                    if(check_parent_Type(((UserDefinedType) right_expression_type).getClassDeclaration().getParentName().getName(), ((UserDefinedType) left_expression_type).getName().getName()))
                        return new BooleanType();
                    else
                        return new NoType();
                else
                    return new NoType();
            }else {
                return new BooleanType();
            }
        }
        else if (op.equals(BinaryOperator.mult) || op.equals(BinaryOperator.div) || op.equals(BinaryOperator.add) ||
                op.equals(BinaryOperator.sub) || op.equals(BinaryOperator.gt) || op.equals(BinaryOperator.lt)){
            if(!((left_expression_type instanceof IntType  || left_expression_type instanceof NoType) &&
                    (right_expression_type instanceof IntType || right_expression_type instanceof  NoType))){
                SymbolTable.error = true;
                add_error(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                //errors.put(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                return new NoType();
            }else if(op.equals(BinaryOperator.lt) || op.equals(BinaryOperator.gt))
                return new BooleanType();
            return new IntType();

        }else if (op.equals(BinaryOperator.and) || op.equals(BinaryOperator.or)){
            if(!((left_expression_type instanceof BooleanType || left_expression_type instanceof NoType) &&
                    (right_expression_type instanceof BooleanType || right_expression_type instanceof  NoType))) {
                SymbolTable.error = true;
                add_error(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                //errors.put(Integer.valueOf(line_number), ":unsupported operand type for " + op.toString());
                return new NoType();
            }else
                return new BooleanType();
        }
        return new NoType();

    }

    public Type get_type(Expression expression){
        if(expression instanceof IntValue)
            return new IntType();
        if(expression instanceof BooleanValue)
            return new BooleanType();
        if(expression instanceof StringValue)
            return new StringType();

        if(expression instanceof ArrayCall) {
            Type instance_type = get_type(((ArrayCall) expression).getInstance());
            Type index_type = get_type(((ArrayCall) expression).getIndex());
            if(!(index_type instanceof IntType)){
                SymbolTable.error = true;
                add_error(Integer.valueOf(expression.get_line_number()), ":ArrayCall index is not Integer" );
                //errors.put(Integer.valueOf(expression.get_line_number()), ":ArrayCall index is not Integer" );
            }
            return instance_type;
        }
        if(expression instanceof BinaryExpression){

            Type left_type = get_type(((BinaryExpression) expression).getLeft());
            Type right_type = get_type(((BinaryExpression) expression).getRight());
            BinaryOperator op = ((BinaryExpression) expression).getBinaryOperator();
            line_number = expression.get_line_number();
            return binary_subType(left_type, right_type, op);

        }
        if(expression instanceof Identifier) {
            try {
                SymbolTableItem identifier_symbolTableItem = SymbolTable.top.get("#Variable_" + ((Identifier) expression).getName());
                if (identifier_symbolTableItem instanceof SymbolTableVariableItemBase) {
                    return get_identifier_type(((SymbolTableVariableItemBase) identifier_symbolTableItem).getType());
                }
            } catch (ItemNotFoundException e) {
                return new NoType();
            }
        }
        if(expression instanceof Length) {
            Type exp_type = get_type(((Length) expression).getExpression());
            if(exp_type instanceof ArrayType || exp_type instanceof NoType){
                return new IntType();
            }else {
                SymbolTable.error = true;
                add_error(Integer.valueOf(expression.get_line_number()), ":Length expression is not array" );
                //errors.put(Integer.valueOf(expression.get_line_number()), ":Length expression is not array" );
                return new NoType();
            }
        }
        if(expression instanceof MethodCall) {
            //TODO : implemented MethodCall
            Type instance_exp_type = get_type(((MethodCall) expression).getInstance());
            Type identifier_type = get_type(((MethodCall) expression).getMethodName());
            ArrayList <Type> arg_types = new ArrayList<>();
            for (Expression arg_exp : ((MethodCall) expression).getArgs())
                arg_types.add(get_type(arg_exp));
        }
        if(expression instanceof  NewArray) {
           //It doesn't have any error
        }
        if(expression instanceof  NewClass) {
            Type identifier_type = get_type(((NewClass) expression).getClassName());
            if(identifier_type instanceof NoType) {
                SymbolTable new_class_symbolTable = symbol_table_items.get(((NewClass) expression).getClassName().getName());
                if(new_class_symbolTable != null){
                    for(UserDefinedType class_defined : class_defined_declaration){
                        if(class_defined.getName().getName().equals(((NewClass) expression).getClassName().getName())){
                            return class_defined;
                        }
                    }
                }
                else{
                    SymbolTable.error = true;
                    add_error(Integer.valueOf(expression.get_line_number()), ":class " + ((NewClass) expression).getClassName().getName()+ " is not declared" );
                    //errors.put(Integer.valueOf(expression.get_line_number()), ":class " + ((NewClass) expression).getClassName().getName()+ " is not declared" );
                    return new NoType();
                }
            }else {
                SymbolTable.error = true;
                add_error(Integer.valueOf(expression.get_line_number()), ":class " + ((NewClass) expression).getClassName().getName() +" is not declared" );
                //errors.put(Integer.valueOf(expression.get_line_number()), ":class " + ((NewClass) expression).getClassName().getName() +" is not declared" );
                return new NoType();
            }
        }
        if(expression instanceof This) {
            for ( String key : symbol_table_items.keySet() ) {
                if(symbol_table_items.get(key) == SymbolTable.top.getPre()){
                    for(UserDefinedType user_defined : user_defined_declaration){
                        if(user_defined.getName().getName().equals(key)){
                            return user_defined;
                        }
                    }
                }
            }
            return new NoType();
        }
        if(expression instanceof UnaryExpression) {
            Type unary_expression_type = get_type(((UnaryExpression) expression).getValue());
            UnaryOperator op = ((UnaryExpression) expression).getUnaryOperator();
            line_number = expression.get_line_number();
            return unary_subType(unary_expression_type, op);
        }
        return new NoType();
    }

    public Type get_identifier_type(Type type) {
        if(type.toString().equals("int"))
            return new IntType();
        if(type.toString().equals("boolean"))
            return new BooleanType();
        if(type.toString().equals("string"))
            return new StringType();
        if(type.toString().equals("int[]"))
            return new ArrayType();
        if(type.toString().equals("NoType"))
            return new NoType();
        return type;
    }

    @Override
    public void visit(Program program) {
        symbolTable_top = SymbolTable.top;
        program.getMainClass().accept(this);
        for (ClassDeclaration classDec : program.getClasses()) {
            classDec.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        String className = classDeclaration.getName().getName();

        classDeclaration.getName().accept(this);

        if(classDeclaration.getParentName() != null) {
            classDeclaration.getParentName().accept(this);
        }
        SymbolTable.push(symbol_table_items.get(className));

        for(VarDeclaration varDec : classDeclaration.getVarDeclarations()) {
            varDec.accept(this);
        }

        for(MethodDeclaration methodDec : classDeclaration.getMethodDeclarations()) {
            methodDec.accept(this);
        }
        SymbolTable.pop();
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        SymbolTable top = SymbolTable.top;
        SymbolTable currentMethod = new SymbolTable();
        currentMethod.setPre(top);
        SymbolTable.push(currentMethod);

        for(VarDeclaration argDec : methodDeclaration.getArgs()) {
            argDec.accept(this);

        }
        for(VarDeclaration localVarDec : methodDeclaration.getLocalVars()) {
            localVarDec.accept(this);
        }
        for(Statement stmt : methodDeclaration.getBody()) {
            stmt.accept(this);
        }
        methodDeclaration.getReturnValue().accept(this);
        SymbolTable.pop();
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {

        String varName = varDeclaration.getIdentifier().getName();

        if(varDeclaration.getType() instanceof UserDefinedType){

            try {
                symbolTable_top.get("#Class_" + ((UserDefinedType)varDeclaration.getType()).getName().getName());
            } catch (ItemNotFoundException e) {

                SymbolTable.error = true;
                add_error(Integer.valueOf(varDeclaration.get_line_number()), ":variable " + ((UserDefinedType) varDeclaration.getType()).getName().getName() + " is not declared");
                //errors.put(Integer.valueOf(varDeclaration.get_line_number()), ":variable " + ((UserDefinedType) varDeclaration.getType()).getName().getName() + " is not declared");
            }
        }
        SymbolTableVariableItemBase variable_item = new SymbolTableVariableItemBase(varName, varDeclaration.getType(),0);
        try {
            SymbolTable.top.put(variable_item);
        } catch (ItemAlreadyExistsException e) {

        }
        varDeclaration.getIdentifier().accept(this);
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {
        SymbolTable top = SymbolTable.top;

        try {
            symbolTable_top.get("#Class_"+identifier.getName());
        } catch (ItemNotFoundException e1) {
            try {
                top.get("#Class_" + identifier.getName());
            } catch (ItemNotFoundException e2) {
                try {
                    top.get("#Method_" + identifier.getName());
                } catch (ItemNotFoundException e3) {
                    try {
                        top.get("#Variable_" + identifier.getName());
                    } catch (ItemNotFoundException e4) {
                        SymbolTable.error = true;
                        add_error(Integer.valueOf(identifier.get_line_number()), ":variable " + identifier.getName() + " is not declared");
                        //errors.put(Integer.valueOf(identifier.get_line_number()), ":variable " + identifier.getName() + " is not declared");
                        try {
                            top.put(new SymbolTableVariableItemBase(identifier.getName(), new NoType(), index));
                            index++;
                        } catch (ItemAlreadyExistsException e5) { }
                    }
                }
            }
        }
    }

    @Override
    public void visit(Length length) {

        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {

        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);
    }

    @Override
    public void visit(NewArray newArray) {

    }

    @Override
    public void visit(NewClass newClass) {

        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {

    }

    @Override
    public void visit(UnaryExpression unaryExpression) {

        unaryExpression.getValue().accept(this);
    }

    @Override
    public void visit(BooleanValue value) {

    }

    @Override
    public void visit(IntValue value) {

    }

    @Override
    public void visit(StringValue value) {

    }

    @Override
    public void visit(Assign assign) {
        get_type(assign.getrValue());
        get_type(assign.getlValue());
        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
    }

    @Override
    public void visit(Block block) {
        for(Statement stms : block.getBody()) {
            stms.accept(this);
        }
    }

    @Override
    public void visit(Conditional conditional) {

        Type conditional_type = get_type(conditional.getExpression());
        if(!(conditional_type instanceof BooleanType || conditional_type instanceof NoType)){
            add_error(Integer.valueOf(conditional.get_line_number()), ":condition type must be boolean");
            //print("Line:" + conditional.get_line_number() + ":condition type must be boolean");
        }
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if( conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {

        Type loop_type = get_type(loop.getCondition());
        if(!(loop_type instanceof BooleanType || loop_type instanceof NoType )){
            add_error(Integer.valueOf(loop.get_line_number()),":condition type must be boolean" );
            //print("Line:" + loop.get_line_number() + ":condition type must be boolean");
        }
        loop.getCondition().accept(this);
        loop.getBody().accept(this);

    }

    @Override
    public void visit(Write write) {
        Type write_type = get_type(write.getArg());
        if(!(write_type instanceof IntType || write_type instanceof NoType ||
                write_type instanceof ArrayType || write_type instanceof StringType)){
            add_error(Integer.valueOf(write.get_line_number()), ":unsupported type for writeln");
            //print("Line:" + write.get_line_number() + ":unsupported type for writeln");
        }
        write.getArg().accept(this);
    }
}