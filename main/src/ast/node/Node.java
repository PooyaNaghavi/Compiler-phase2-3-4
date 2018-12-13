package ast.node;

import ast.Visitor;

public abstract class Node {
    public int line;
    public void set_line_num(int l){
      line = l;
    }
    public String get_line_number(){
      return String.valueOf(line);
    }
    public void accept(Visitor visitor) {}
}
