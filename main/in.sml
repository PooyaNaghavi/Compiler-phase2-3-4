class MainClass{
  def main(): int{
    return 23;
  }
}
class SecondClass{
    var x : int;
    def method(): int{
        return 0;
    }
    def sag(): int{
        var i : int;
        i = this.method();
        return 23;
    }
}