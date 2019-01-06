.class public MainClass
.super java/lang/Object
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public main()I
.limit stack 20
.limit locals 2
new SecondClass
dup
invokespecial SecondClass/<init>()V
invokevirtual SecondClass/method()LThirdClass;
ldc 23
ireturn
.end method
