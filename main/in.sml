class MainClass{
  def main(): int{
      #writeln(new ThirdClass().m());
      new SecondClass().method(3);
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
   def method(s : int): ThirdClass{
       #aa = new int[10];
       #aa[1] = 1;
       #b[1] = 10;
       #e = (aa = b)[1] + 2;
       #f = (3 < 2) || (3 > 2);
       #f = e < 3;
       #c = new ThirdClass();

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
       f = true == true;
       if(f)then
           writeln(5);
        else
           writeln(4);

       return new ThirdClass();
   }
   def method2(): ThirdClass{
        return new ThirdClass();
   }
  }

  class ThirdClass {
    var a : int;
    def m(s : int): int {
        a = 5;
        s = a;
        return s;
    }
  }
