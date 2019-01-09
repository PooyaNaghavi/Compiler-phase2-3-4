package ast.node.declaration;

import ast.Visitor;
import ast.node.expression.Identifier;

import java.util.ArrayList;

public class ClassDeclaration extends Declaration{
    private Identifier name;
    private Identifier parentName;
    private ArrayList<VarDeclaration> varDeclarations = new ArrayList<>();
    private ArrayList<MethodDeclaration> methodDeclarations = new ArrayList<>();

    public ClassDeclaration(Identifier name) {
        this.name = name;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public Identifier getParentName() {
        return parentName;
    }

    public void setParentName(Identifier parentName) {
        this.parentName = parentName;
    }

    public ArrayList<VarDeclaration> getVarDeclarations() {
        return varDeclarations;
    }

    public void addVarDeclaration(VarDeclaration varDeclaration) {
        this.varDeclarations.add(varDeclaration);
    }

    public ArrayList<MethodDeclaration> getMethodDeclarations() {
        return methodDeclarations;
    }

    public void addMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclarations.add(methodDeclaration);
    }

    @Override
    public String toString() {
        return "ClassDeclaration";
    }

    @Override
    public ArrayList<String> to_byte_code() {
        ArrayList<String> byte_code = new ArrayList<String>();
        byte_code.add(".class public " + this.name.getName());
        String parent_name;
        if(this.parentName != null) {
            parent_name = this.parentName.getName();
        }
        else{
            parent_name = "Object";
        }

        byte_code.add(".super " + parent_name);

        return byte_code;
    }

    public ArrayList<String> constructor_byte_code() {

        ArrayList<String> byte_code = new ArrayList<String>();
        String parent_name;
        if(this.parentName != null) {
            parent_name = this.parentName.getName();
        }
        else{
            parent_name = "Object";
        }

        byte_code.add(".method public <init>()V");
        byte_code.add("aload_0");
        byte_code.add("invokespecial " + parent_name + "/<init>()V");
        byte_code.add("return");
        byte_code.add(".end method");

        return byte_code;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
