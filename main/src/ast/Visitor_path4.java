package ast;
//import ast.VisitorImpl;
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
import java.util.HashMap;

public class Visitor_path4 extends  VisitorImpl{
public SymbolTable sym_top ;

    @Override
    public void visit(Program program) {
        sym_top = SymbolTable.top;
        program.getMainClass().accept(this);
        for (ClassDeclaration classDec : program.getClasses()) {
            classDec.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        String className = classDeclaration.getName().getName();
        String new_classname = "null";

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

        String methodName = methodDeclaration.getName().getName();
        SymbolTable top = SymbolTable.top;
//        SymbolTableMethodItem md = new SymbolTableMethodItem(methodName, methodDeclaration.getTypes());
        SymbolTable currentMethod = new SymbolTable();
        currentMethod.setPre(top);
        SymbolTable.push(currentMethod);

//        methodDeclaration.getName().accept(this);

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
            SymbolTable user_define_symbol = symbol_table_items.get(varDeclaration.getIdentifier().getName());
            if(user_define_symbol == null){
                errors.put(Integer.valueOf(varDeclaration.get_line_number()), ": variable "+varDeclaration.getIdentifier().getName()+" is not declared");
            }

        }
        SymbolTableVariableItemBase vd = new SymbolTableVariableItemBase(varName, varDeclaration.getType(),0);
        try {
            SymbolTable.top.put(vd);
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


//        SymbolTableMethodItem md = new SymbolTableMethodItem(methodName, methodDeclaration.getTypes());
//        SymbolTable currentMethod = new SymbolTable();
//        try {
//            top.get("#Class"+identifier.getName());
//        }catch (ItemNotFoundException e){
//            try {
//                top.get("#Method"+identifier.getName())
//            }
//
//            }
        try {
            sym_top.get("#Class_"+identifier.getName());


        } catch (ItemNotFoundException e) {
            try {
                top.get("#Class_" + identifier.getName());
            }
            catch(ItemNotFoundException e3) {
                try {
                    top.get("#Method_"+identifier.getName());
                } catch (ItemNotFoundException e1) {
                    try {
                        top.get("#Variable_"+ identifier.getName());
                    } catch (ItemNotFoundException e2) {
                        SymbolTable.error = true;
                        errors.put(Integer.valueOf(identifier.get_line_number()), ": variable "+identifier.getName()+" is not declared");
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

        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if( conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
    }

//        @Override
//        public void visit(MethodCallInMain methodCallInMain) {
//            //TODO: implement appropriate visit functionality
//        }

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

