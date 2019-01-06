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
.method public method()LThirdClass;
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
ldc 6
putfield SecondClass/g I
BEGIN_WHILE_0 :
aload_0
aload_0
getfield SecondClass/g I
ldc 1
isub
putfield SecondClass/g I
aload_0
getfield SecondClass/g I
ldc 3
if_icmple ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
ifeq END_WHILE_0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield SecondClass/g I
invokevirtual java/io/PrintStream/println(I)V
goto BEGIN_WHILE_0
END_WHILE_0 :
new ThirdClass
dup
invokespecial ThirdClass/<init>()V
areturn
.end method
