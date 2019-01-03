package ast.node.expression;
import ast.Visitor;
import java.util.ArrayList;

public class BinaryExpression extends Expression {

    private Expression left;
    private Expression right;
    private BinaryOperator binaryOperator;

    public BinaryExpression(Expression left, Expression right, BinaryOperator binaryOperator) {
        this.left = left;
        this.right = right;
        this.binaryOperator = binaryOperator;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    public void setBinaryOperator(BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    @Override
    public String toString() {
        return "BinaryExpression " + binaryOperator.name();
    }

    @Override
    public ArrayList<String> to_byte_code() {
        ArrayList<String> byte_code = new ArrayList<String>();
        switch (binaryOperator){
            case gt:
                break;
            case lt:
                break;
            case eq:
                break;
            case or:
                break;
            case add:

                break;
            case and:
                break;
            case div:
                break;
            case neq:
                break;
            case sub:
                break;
            case mult:
                break;
            case assign:
                break;
        }
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
