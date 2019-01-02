package ast.node.statement;

import ast.Type.PrimitiveType.StringType;
import ast.Visitor;
import ast.node.expression.Expression;
import ast.node.expression.Value.StringValue;

import java.util.ArrayList;

public class Write extends Statement {
    private Expression arg;

    public Write(Expression arg) {
        this.arg = arg;
    }

    public Expression getArg() {
        return arg;
    }

    public void setArg(Expression arg) {
        this.arg = arg;
    }

    @Override
    public String toString() {
        return "Write";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    @Override
    public ArrayList<String> to_byte_code() {

        ArrayList<String> byte_code = new ArrayList<String>();
        byte_code.add("getstatic java/lang/System/out Ljava/io/PrintStream;");

        if (this.arg instanceof StringValue) {
            byte_code.add("ldc " + ((StringValue) this.arg).getConstant());
        }
        byte_code.add("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        return byte_code;
    }
}
