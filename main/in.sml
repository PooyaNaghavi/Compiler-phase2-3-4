class MainClass{
  def main(): int{
      writeln(true);
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
   def method(): int{
       #b = new int[10];
       #aa = new int[10];
       #b[2] = 2;
       #a = x.m();
       #d = !false;
       #f = (2 + 3) < 3 || false;
       #aa[1] = 1;
       #b[1] = 10;
       #e = (aa = b)[1] + 2;
       #f = (3 < 2) || (3 > 2);
       #f = e < 3;
       #c = new ThirdClass();
       g = 3;
       if(g > 2) then
       {
          g = 1;
          writeln(g = 5);
       }
            writeln(g);

       #writeln(f);
       return 23;
   }
  }

  class ThirdClass {
    var a : int;
    def m(): int {
        return 11;
    }
  }