.class public SecondClass
.super ThirdClass
.field protected x LThirdClass;
.field protected b [I
.method public <init>()V
aload_0
invokespecial ThirdClass/<init>()V
return
.end method
.method public method()I
.limit stack 20
.limit locals 2
aload_0
ldc 10
newarray int
putfield SecondClass/b [I
aload_0
getfield SecondClass/b [I
ldc 2
ldc 2
iastore
aload_0
new ThirdClass
dup
invokespecial ThirdClass/<init>()V
invokevirtual ThirdClass/m()I
putfield SecondClass/a I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield SecondClass/b [I
ldc 2
iaload
invokevirtual java/io/PrintStream/println(I)V
ldc 23
ireturn
.end method
