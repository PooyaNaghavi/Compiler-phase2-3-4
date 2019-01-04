.class public SecondClass
.super ThirdClass
.field protected x LThirdClass;
.field protected b [I
.field protected c LThirdClass;
.field protected d Z
.field protected e I
.method public <init>()V
aload_0
invokespecial ThirdClass/<init>()V
return
.end method
.method public method()I
.limit stack 20
.limit locals 2
aload_0
ldc 1
ldc 0
isub
putfield SecondClass/d Z
aload_0
ldc 2
ineg
ineg
putfield SecondClass/e I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield SecondClass/e I
invokevirtual java/io/PrintStream/println(I)V
ldc 23
ireturn
.end method
