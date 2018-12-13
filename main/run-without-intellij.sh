export CLASSPATH=".:/Library/antlr-4.7.1-complete.jar:$CLASSPATH"
java -jar /Library/antlr-4.7.1-complete.jar Smoola.g4
javac ./ast.symbolTable/*.java
javac
javac *.java
java org.antlr.v4.gui.TestRig Smoola program < in.sml
rm *.class
rm *.tokens
rm Smoola*.java
