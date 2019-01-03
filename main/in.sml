class MainClass{
  def main(): int{
      writeln(true);
      return 23;
  }
 }

 class SecondClass extends ThirdClass{
   def method(): int{
       a = 5;
       writeln(a);
       return 23;
   }
  }

  class ThirdClass {
    var a : int;
  }