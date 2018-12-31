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
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Visitor_pass5 extends VisitorImpl{

    public ArrayList<ArrayList<String> > lines = new ArrayList<ArrayList<String>>();
    public boolean is_class = false;

    public void writeUsingFiles(ArrayList<String> class_lines, String class_name) {
        try {
            Path file = Paths.get("./output/" + class_name + ".j");
            Files.write(file, class_lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void visit(Program program) {
        program.getMainClass().accept(this);
        writeUsingFiles(lines.get(lines.size() - 1), program.getMainClass().getName().getName());
        for (ClassDeclaration classDec : program.getClasses()) {
            classDec.accept(this);
            writeUsingFiles(lines.get(lines.size() - 1), classDec.getName().getName());
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {

        lines.add(classDeclaration.to_byte_code());

        classDeclaration.getName().accept(this);

        if(classDeclaration.getParentName() != null) {
            classDeclaration.getParentName().accept(this);
        }

        for(VarDeclaration varDec : classDeclaration.getVarDeclarations()) {
            is_class = true;
            varDec.accept(this);
        }
        is_class = false;

        ArrayList<String> class_byte_code = lines.get(lines.size() - 1);
        class_byte_code.addAll(classDeclaration.constructor_byte_code());
        lines.set(lines.size() - 1, class_byte_code);

        for(MethodDeclaration methodDec : classDeclaration.getMethodDeclarations()) {
            methodDec.accept(this);
        }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {

        ArrayList<String> method_byte_code = lines.get(lines.size() - 1);
        method_byte_code.addAll(methodDeclaration.to_byte_code());
        lines.set(lines.size() - 1, method_byte_code);

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

        method_byte_code = lines.get(lines.size() - 1);
        method_byte_code.addAll(methodDeclaration.return_byte_code());
        lines.set(lines.size() - 1, method_byte_code);


    }

    @Override
    public void visit(VarDeclaration varDeclaration) {

        if(is_class) {
            ArrayList<String> variable_byte_code = lines.get(lines.size() - 1);
            variable_byte_code.addAll(varDeclaration.to_byte_code());
            lines.set(lines.size() - 1, variable_byte_code);
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
        ArrayList<String> this_byte_code = lines.get(lines.size() - 1);
        this_byte_code.addAll(instance.to_byte_code());
        lines.set(lines.size() - 1, this_byte_code);
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
