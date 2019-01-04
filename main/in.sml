class MainClass{
  def main(): int{
      writeln(true);
      return 23;
  }
 }

 class SecondClass extends ThirdClass{
    var x : ThirdClass;
    var b : int[];
   def method(): int{
       b = new int[10];
       b[2] = 2;
       a = x.m();
       writeln(b[2]);
       return 23;
   }
  }

  class ThirdClass {
    var a : int;
    def m(): int {
        return 5;
    }
  }