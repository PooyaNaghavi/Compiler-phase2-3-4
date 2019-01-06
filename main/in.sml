class MainClass{
  def main(): int{
      #writeln(new ThirdClass().m());
      new SecondClass().method();
      return 23;
  }
 }

 class SecondClass extends ThirdClass{
    var x : ThirdClass;
    var aa : int[];
    var b : int[];
    var c : ThirdClass;
    var d : boolean;
    #var e : int;
    var f : boolean;
    var g : int;
    var e : int;
    var h : int;
    var i : int;
   def method(): ThirdClass{
       b = new int[10];
       #aa = new int[10];
       b[2] = 2;
       #a = x.m();
       #d = !false;
       #f = (2 + 3) < 3 || false;
       #aa[1] = 1;
       #b[1] = 10;
       #e = (aa = b)[1] + 2;
       #f = (3 < 2) || (3 > 2);
       #f = e < 3;
       #c = new ThirdClass();
       i = this.method2().m();
       #if(g > 2) then
       #{
        #  g = 1;
         # writeln(g = 5);
       #}
       while((g = g - 1) > 3){
            writeln(g);
       }
       #writeln(g + 2);
       #writeln(g);
       #writeln(b[2]);
       #writeln(g > 2);
       #writeln(new ThirdClass().m());
       writeln(this.method2());
       return new ThirdClass();
   }
   def method2(): ThirdClass{
        return new ThirdClass();
   }
  }

  class ThirdClass {
    var a : int;
    def m(): int {
        return 11;
    }
  }