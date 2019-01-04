class MainClass{
  def main(): int{
      writeln(true);
      return 23;
  }
 }

 class SecondClass extends ThirdClass{
    var x : ThirdClass;
    var b : int[];
    var c : ThirdClass;
    var d : boolean;
    var e : int;
   def method(): int{
       #b = new int[10];
       #b[2] = 2;
       #a = x.m();
       d = !false;
       e = -(-2);
       #c = new ThirdClass();
       writeln(e);
       return 23;
   }
  }

  class ThirdClass {
    var a : int;
    def m(): int {
        return 11;
    }
  }