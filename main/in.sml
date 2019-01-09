class MyMain {
    def main() : int {
        writeln(new Check().main());
        return 0;
    }
}

class Check {
    def main() : int {
        var b : string;
        b = "2";
        if(b == "")then
            writeln(b);
        return 0;
    }
}
