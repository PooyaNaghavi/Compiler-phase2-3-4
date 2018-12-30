package ast.node.expression;

import ast.Visitor;

import java.util.ArrayList;

public class This extends Expression {
    @Override
    public String toString() {
        return "This";
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
