import ast.VisitorImpl;
import ast.node.Program;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import ast.*;
import ast.node.*;
import ast.node.declaration.*;
import ast.node.expression.*;
import ast.node.statement.*;
import ast.node.expression.Value.*;
import ast.Type.*;
import ast.Type.ArrayType.*;
import ast.Type.PrimitiveType.*;
import ast.Type.UserDefinedType.*;
import symbolTable.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// Visit https://stackoverflow.com/questions/26451636/how-do-i-use-antlr-generated-parser-and-lexer
public class MySmoola {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        SmoolaLexer lexer = new SmoolaLexer(reader);   // SmoolaLexer in your project
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SmoolaParser parser = new SmoolaParser(tokens);   // SmoolaParser in your project
        Program p = parser.program().p; // program is the name of the start rule

        SymbolTable.push(new SymbolTable());
        SymbolTable.error = false;
        SymbolTable.has_error = true;
        SymbolTable.path1_error = false;
        SymbolTable.path2_error = true;
        SymbolTable.path3_error = true;
        SymbolTable.path4_error = true;

        VisitorImpl visitor = new VisitorImpl();
        p.accept(visitor);
        SymbolTable.path1_error = true;
        SymbolTable.path2_error = false;
        p.accept(visitor);
        SymbolTable.path2_error = true;
        SymbolTable.path3_error = false;
        p.accept(visitor);
        SymbolTable.path3_error = true;
        SymbolTable.path4_error = false;
        //syn_program.accept(visitor);
        Visitor_path4 path4 = new Visitor_path4();
        if(SymbolTable.circular_inheritance == false) {
            p.accept(path4);
        }
        SymbolTable.path4_error = true;
        if(SymbolTable.error == false){
            SymbolTable.has_error = false;
        }
        if(SymbolTable.has_error == false)
            p.accept(visitor);
        else{
            HashMap<Integer, ArrayList<String>> errors = visitor.getErrors();
            ArrayList<Integer> keys = new ArrayList(errors.keySet());
            Collections.sort(keys);
            for (Integer i : keys)
            {
                ArrayList<String> error_temp = errors.get(i);
                for(String error : error_temp)
                    System.out.println("Line:" + i + error);
            }
        }
    }
}
