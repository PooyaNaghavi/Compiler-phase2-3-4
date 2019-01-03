.class public SecondClass
.super ThirdClass
.method public <init>()V
aload_0
invokespecial ThirdClass/<init>()V
return
.end method
.method public method()I
.limit stack 20
.limit locals 2
aload_0
ldc 5
putfield SecondClass/a I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield SecondClass/a I
invokevirtual java/io/PrintStream/println(I)V
ldc 23
ireturn
.end method
