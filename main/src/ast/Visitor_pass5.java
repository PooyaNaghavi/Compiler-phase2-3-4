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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Visitor_pass5 extends VisitorImpl{

    ArrayList<ArrayList<String> > lines = new ArrayList<ArrayList<String>>();
    int class_index = 0;

    @Override
    public void visit(Program program) {
        program.getMainClass().accept(this);
        for (ClassDeclaration classDec : program.getClasses()) {
            classDec.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {

        for (String s : classDeclaration.to_byte_code())
            lines.get(class_index).add(s);

        class_index++;
        classDeclaration.getName().accept(this);

        if(classDeclaration.getParentName() != null) {
            classDeclaration.getParentName().accept(this);
        }

        for(VarDeclaration varDec : classDeclaration.getVarDeclarations()) {
            varDec.accept(this);
        }

        for(MethodDeclaration methodDec : classDeclaration.getMethodDeclarations()) {
            methodDec.accept(this);
        }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {

        methodDeclaration.getName().accept(this);

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

    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
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

    }

    @Override
    public void visit(Length length) {

        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {

        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);
        for(Expression exp : methodCall.getArgs()){
            exp.accept(this);
        }
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
        if (!(assign.getlValue() == null || assign.getrValue() == null)) {
            assign.getlValue().accept(this);
            assign.getrValue().accept(this);

        } else if (assign.getrValue() != null) {
            assign.getrValue().accept(this);

        } else if (assign.getlValue() != null){
            assign.getlValue().accept(this);

        }
    }

    @Override
    public void visit(Block block) {
        for(Statement stms : block.getBody()) {
            stms.accept(this);
        }
    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if( conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(MethodCallInMain methodCallInMain) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(While loop) {
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        write.getArg().accept(this);
    }
}
