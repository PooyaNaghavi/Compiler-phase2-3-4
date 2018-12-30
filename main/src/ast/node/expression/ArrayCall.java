package ast.node.expression;

import ast.Visitor;

import java.util.ArrayList;

public class ArrayCall extends Expression {
    private Expression instance;
    private Expression index;

    public ArrayCall(Expression instance, Expression index) {
        this.instance = instance;
        this.index = index;
    }
    public ArrayCall(Expression instance, Expression index, int line) {
        this.instance = instance;
        this.index = index;
        this.line = line;
    }


    public Expression getInstance() {
        return instance;
    }

    public void setInstance(Expression instance) {
        this.instance = instance;
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ArrayCall";
    }

    @Override
    public ArrayList<String> to_byte_code() {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
