.class public MainClass
.super java/lang/Object
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public main()I
.limit stack 20
.limit locals 1
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Hello World"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ldc 23
ireturn
.end method