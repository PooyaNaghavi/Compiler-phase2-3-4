.class public MainClass
.super Object
.method public <init>()V
aload_0
invokespecial Object/<init>()V
return
.end method
.method public main()I
.limit stack 20
.limit locals 2
new SecondClass
dup
invokespecial SecondClass/<init>()V
invokevirtual SecondClass/method()I
ldc 0
ireturn
.end method
