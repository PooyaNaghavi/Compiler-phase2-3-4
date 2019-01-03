class MainClass{
  def main(): int{
      writeln(true);
      return 23;
  }
 }

 class SecondClass extends ThirdClass{
    var x : ThirdClass;
   def method(): int{
       a = x.m();
       writeln(a);
       return 23;
   }
  }

  class ThirdClass {
    var a : int;
    def m(): int {
        return 5;
    }
  }