
class MainClass{
 def main(): int{
   writeln((new sag().sex2(10).sex2(10).sex1(12)));
    return 0;
 }
}
class Tataloo extends sag{

    def sex(x:int, f:string, h:int): int{
        writeln((new sag().sex1(12)));
        return 10;
    }

}
class sag {
var ff : sag;
 def sex1(x : int): int{
        var ffff: string;
        var f : int[];
        ffff = "ali0";
        x = x + 10 + 2;
        x = x * 10 + 23;
        f = new int[10];
        f[9] = 10;
        ff = new sag();
        writeln(ff.sex3(10));
        writeln(f.length);
        return x + 10 + f[9];
    }
    def sex2(x : int): sag{

            return new sag();
        }
   def sex3(x : int): int{

            return 111;
        }
}