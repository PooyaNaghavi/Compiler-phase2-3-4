.class public SecondClass
.super ThirdClass
.field protected x LThirdClass;
.field protected aa [I
.field protected b [I
.field protected c LThirdClass;
.field protected d Z
.field protected f Z
.field protected g I
.field protected e I
.field protected h I
.method public <init>()V
aload_0
invokespecial ThirdClass/<init>()V
return
.end method
.method public method()I
.limit stack 20
.limit locals 2
aload_0
ldc 3
putfield SecondClass/g I
aload_0
getfield SecondClass/g I
ldc 2
if_icmple ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
ifeq ELSE_IF_0
aload_0
ldc 1
putfield SecondClass/g I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
ldc 5
putfield SecondClass/g I
ldc 5
invokevirtual java/io/PrintStream/println(I)V
ELSE_IF_0 :
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield SecondClass/g I
invokevirtual java/io/PrintStream/println(I)V
ldc 23
ireturn
.end method
