package ast.node.statement;

import ast.Type.PrimitiveType.StringType;
import ast.Visitor;
import ast.node.expression.ArrayCall;
import ast.node.expression.Expression;
import ast.node.expression.Identifier;
import ast.node.expression.Value.BooleanValue;
import ast.node.expression.Value.IntValue;
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

        if (this.arg instanceof StringValue)
            byte_code.add("ldc " + ((StringValue) this.arg).getConstant());
        else if (this.arg instanceof IntValue)
            byte_code.add("ldc " + ((IntValue) this.arg).getConstant());
        else if (this.arg instanceof BooleanValue)
            byte_code.add("ldc " + ((BooleanValue) this.arg).get_constant());
        else if  (this.arg instanceof Identifier)
            byte_code.addAll(((Identifier)arg).to_byte_code("right"));
        else if (this.arg instanceof ArrayCall)
            byte_code.addAll(((ArrayCall)arg).to_byte_code("right"));
        byte_code.add("invokevirtual java/io/PrintStream/println("+ arg.getType().to_byte_code() + ")V");
        return byte_code;
    }
}
