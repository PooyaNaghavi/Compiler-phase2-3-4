package ast;

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

public class VisitorImpl implements Visitor {
    public int index;
    public int name_index;
    public boolean flag;
    static HashMap<String, SymbolTable> symbol_table_items = new HashMap<>();
    static HashMap<Integer, String> errors = new HashMap<>();
    static ArrayList<UserDefinedType> user_defines_declaration;

    public HashMap<Integer, String> getErrors() {
        return errors;
    }

    public void print(Object str) {
        System.out.println(str);
    }

    @Override
    public void visit(Program program) {
        flag = true;
        if (!SymbolTable.has_error) {
            print(program.toString());
        }
        program.getMainClass().accept(this);
        for (ClassDeclaration classDec : program.getClasses()) {
            classDec.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        String class_name = classDeclaration.getName().getName();
        String new_class_name = null;
        if (!SymbolTable.has_error) {
            print(classDeclaration.toString());
        } else if (!SymbolTable.path1_error) {
            SymbolTableClassItem class_item = new SymbolTableClassItem(class_name);
            SymbolTable current_class = new SymbolTable();
            try {
                SymbolTable.top.put(class_item);
            } catch (ItemAlreadyExistsException e) {
                name_index = 1;
                while (flag == true) {
                    try {
                        new_class_name = "MiliPooyi_" + class_name + "_" + Integer.toString(name_index);
                        SymbolTableClassItem temp_class_item = new SymbolTableClassItem(new_class_name);
                        SymbolTable.top.put(temp_class_item);
                        classDeclaration.getName().setName(new_class_name);
                        flag = false;
                    } catch (ItemAlreadyExistsException e1) {
                        name_index++;
                    }
                }
                flag = true;
                errors.put(Integer.valueOf(classDeclaration.get_line_number()), ":Redefinition of class " + class_name);
                //print("Line:" + classDeclaration.get_line_number() + ":Redefinition of class " + class_name);
                SymbolTable.error = true;
            }
            SymbolTable.push(current_class);
        } else if (!SymbolTable.path2_error) {
            if (classDeclaration.getParentName() != null) {
                String parent_class_name = classDeclaration.getParentName().getName();
                symbol_table_items.get(class_name).setPre(symbol_table_items.get(parent_class_name));
                // print(symbol_table_items.get(parent_class_name));
                // print(symbol_table_items.get(class_name).getPre().getInCurrentScope("#Variable_x").getKey());
            }
        } else if (!SymbolTable.path3_error) {
            // SymbolTable new_symbol_table;
            // if(symbol_table_items.get(class_name).getPre() != null)
            //     new_symbol_table = new SymbolTable(symbol_table_items.get(class_name).getPre());

            ArrayList<MethodDeclaration> methodDeclarations = classDeclaration.getMethodDeclarations();
            ArrayList<VarDeclaration> varDeclarations = classDeclaration.getVarDeclarations();

            for (MethodDeclaration method_dec : methodDeclarations) {
                SymbolTableItem symbol_parent_table_item;
                try {
                    symbol_parent_table_item = symbol_table_items.get(class_name).get_parent("#Method_" + method_dec.getName().getName());
                    if (symbol_parent_table_item != null) {
//                  boolean arg_flag = true;
//                  ArrayList<Type> parent_argTypes = ((SymbolTableMethodItem)symbol_parent_table_item).getArgsType();
//                  ArrayList<Type> argTypes = ((SymbolTableMethodItem)symbol_table_items.get(class_name).getInCurrentScope("#Method_" + method_dec.getName().getName())).getArgsType();
//                  if(parent_argTypes.size() == argTypes.size())
//                  {
//                    for(int i = 0; i < argTypes.size(); i++)
//                    {
//                      if(parent_argTypes.get(i).toString() != argTypes.get(i).toString())
//                          arg_flag = false;
//                    }
//                  }
//                  if(arg_flag)
//                  {
                        SymbolTable.error = true;
                        errors.put(Integer.valueOf(method_dec.get_line_number()), ":Redefinition of method " + method_dec.getName().getName());
                        //print("Line:" + method_dec.get_line_number() + ":Redefinition of method " + method_dec.getName().getName());
                        //     }

                    }
                } catch (ItemNotFoundException i1) {
                }
            }

            for (VarDeclaration arg_dec : varDeclarations) {

                SymbolTableItem symbol_parent_table_item;
                try {
                    symbol_parent_table_item = symbol_table_items.get(class_name).get_parent("#Variable_" + arg_dec.getIdentifier().getName());
                    if (symbol_parent_table_item != null) {
                        SymbolTable.error = true;
//                  Type parent_argType = ((SymbolTableVariableItemBase)symbol_parent_table_item).getType();
//                  Type argType = ((SymbolTableVariableItemBase)symbol_table_items.get(class_name).getInCurrentScope("#Variable_" + arg_dec.getIdentifier().getName())).getType();
//                  if(parent_argType.toString().equals(argType.toString()))
//                  {
                        errors.put(Integer.valueOf(arg_dec.get_line_number()), ":Redefinition of variable " + arg_dec.getIdentifier().getName());
//                      //print("Line:" + arg_dec.get_line_number() + ":Redefinition of variable " + arg_dec.getIdentifier().getName());
//               //  }
                    }
                } catch (ItemNotFoundException i1) {
                }
            }
        }
        classDeclaration.getName().accept(this);
        if (classDeclaration.getParentName() != null) {
            classDeclaration.getParentName().accept(this);
        }

        for (VarDeclaration varDec : classDeclaration.getVarDeclarations()) {
            varDec.accept(this);
        }

        for (MethodDeclaration methodDec : classDeclaration.getMethodDeclarations()) {
            methodDec.accept(this);
        }
        if (!SymbolTable.path1_error) {
            if(new_class_name == null)
                new_class_name = class_name;
            symbol_table_items.put(new_class_name, SymbolTable.top);
            SymbolTable.pop();
        }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        if (!SymbolTable.has_error) {
            print(methodDeclaration.toString());
        } else if (!SymbolTable.path1_error) {
            String method_name = methodDeclaration.getName().getName();
            ArrayList<Type> args = methodDeclaration.getArgsType();
            SymbolTableMethodItem method_item = new SymbolTableMethodItem(method_name, args);
            SymbolTable current_method = new SymbolTable();
            try {
                SymbolTable.top.put(method_item);
            } catch (ItemAlreadyExistsException e) {
                name_index = 1;
                while (flag == true) {
                    try {
                        SymbolTableMethodItem temp_method_item = new SymbolTableMethodItem("MiliPooyi_" + method_name + "_" + Integer.toString(name_index), args);
                        SymbolTable.top.put(temp_method_item);
                        flag = false;
                    } catch (ItemAlreadyExistsException e1) {
                        name_index++;
                    }
                }
                flag = true;
                errors.put(Integer.valueOf(methodDeclaration.get_line_number()), ":Redefinition of method " + method_name);
                //print("Line:" + methodDeclaration.get_line_number() + ":Redefinition of method " + method_name);
                SymbolTable.error = true;
            }
            SymbolTable.push(current_method);
        }
        methodDeclaration.getName().accept(this);

        for (VarDeclaration argDec : methodDeclaration.getArgs()) {
            argDec.accept(this);
        }

        for (VarDeclaration localVarDec : methodDeclaration.getLocalVars()) {
            localVarDec.accept(this);
        }
        for (Statement stmt : methodDeclaration.getBody()) {
            stmt.accept(this);
        }
        methodDeclaration.getReturnValue().accept(this);
        if(!SymbolTable.path1_error)
            SymbolTable.pop();
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        String var_name = varDeclaration.getIdentifier().getName();

        if (!SymbolTable.has_error) {
            print(varDeclaration.toString());
        } else if (!SymbolTable.path1_error) {

            Type var_type = varDeclaration.getType();
            SymbolTableVariableItemBase var_item = new SymbolTableVariableItemBase(var_name, var_type, index);
            index++;
            //SymbolTable current_var = new SymbolTable();
            try {
                SymbolTable.top.put(var_item);
            } catch (ItemAlreadyExistsException e) {
                name_index = 1;
                while (flag == true) {
                    try {
                        SymbolTableVariableItemBase temp_var_item = new SymbolTableVariableItemBase("MiliPooyi_" + var_name + "_" + Integer.toString(name_index), var_type, index);
                        SymbolTable.top.put(temp_var_item);
                        flag = false;
                    } catch (ItemAlreadyExistsException e1) {
                        name_index++;
                    }
                }
                flag = true;
                errors.put(Integer.valueOf(varDeclaration.get_line_number()), ":Redefinition of variable " + var_name);
                //print("Line:" + varDeclaration.get_line_number() + ":Redefinition of variable " + var_name);
                SymbolTable.error = true;
            }
            //SymbolTable.push(current_var);
        }
        if(!SymbolTable.path2_error) {
            if(varDeclaration.getType() instanceof UserDefinedType){
                user_defines_declaration.add((UserDefinedType) varDeclaration.getType());
            }
        }
        varDeclaration.getIdentifier().accept(this);
        // SymbolTable.pop();
    }

    @Override
    public void visit(ArrayCall arrayCall) {

        if (!SymbolTable.has_error) {
            print(arrayCall.toString());
        }
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        if (!SymbolTable.has_error) {
            print(binaryExpression.toString());
        }

        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {
        if (!SymbolTable.has_error) {
            print(identifier.toString());
        }
    }

    @Override
    public void visit(Length length) {
        if (!SymbolTable.has_error) {
            print(length.toString());
        }
        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {
        if (!SymbolTable.has_error) {
            print(methodCall.toString());
        }
        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);
        for (Expression args : methodCall.getArgs()) {
            args.accept(this);
        }
    }

    @Override
    public void visit(NewArray newArray) {
        if (!SymbolTable.has_error) {
            print(newArray.toString());
        } else if (!SymbolTable.path1_error) {
            if (newArray.getSize() <= 0) {
                errors.put(Integer.valueOf(newArray.get_line_number()), ":Array length should not be zero or negative");
                //print("Line:" + newArray.get_line_number() + ":Array length should not be zero or negative");
                SymbolTable.error = true;
            }
        }
    }

    @Override
    public void visit(NewClass newClass) {
        if (!SymbolTable.has_error) {
            print(newClass.toString());
        }
        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {
        if (!SymbolTable.has_error) {
            print(instance.toString());
        }
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        if (!SymbolTable.has_error) {
            print(unaryExpression.toString());
        }
        //unaryExpression.getUnaryOperator().accept(this);
        unaryExpression.getValue().accept(this);
    }

    @Override
    public void visit(BooleanValue value) {
        if (!SymbolTable.has_error) {
            print(value.toString());
        }
    }

    @Override
    public void visit(IntValue value) {
        if (!SymbolTable.has_error) {
            print(value.toString());
        }
    }

    @Override
    public void visit(StringValue value) {
        if (!SymbolTable.has_error) {
            print(value.toString());
        }
    }

    @Override
    public void visit(Assign assign) {
        if (!SymbolTable.has_error) {
            print(assign.toString());
        }
        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
    }

    @Override
    public void visit(Block block) {
        if (!SymbolTable.has_error) {
            print(block.toString());
        }
        for (Statement stms : block.getBody()) {
            stms.accept(this);
        }
    }

    @Override
    public void visit(Conditional conditional) {
        if (!SymbolTable.has_error) {
            print(conditional.toString());
        }
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        if (!SymbolTable.has_error) {
            print(loop.toString());
        }
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        if (!SymbolTable.has_error) {
            print(write.toString());
        }
        write.getArg().accept(this);
    }
}