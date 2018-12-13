package ast.node.expression;

import ast.Visitor;

public class NewArray extends Expression {
    private Expression expression;
    private int size;

    public NewArray(int size){
        this.size = size;
    }

    public NewArray(Expression expression) {
        this.expression = expression;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "NewArray";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
