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
.field protected i I
.method public <init>()V
aload_0
invokespecial ThirdClass/<init>()V
return
.end method
.method public method(I)LThirdClass;
.limit stack 21
.limit locals 3
aload_0
ldc 2
newarray int
putfield SecondClass/b [I
aload_0
getfield SecondClass/b [I
ldc 0
ldc 1
iastore
aload_0
getfield SecondClass/b [I
ldc 1
ldc 2
iastore
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
aload_0
ldc 1
ldc 1
if_icmpne ELSE1
ldc 1
goto END1
ELSE1 :
ldc 0
END1 :
putfield SecondClass/f Z
aload_0
getfield SecondClass/f Z
ifeq ELSE_IF_0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 5
invokevirtual java/io/PrintStream/println(I)V
goto END_IF_0
ELSE_IF_0 :
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 4
invokevirtual java/io/PrintStream/println(I)V
END_IF_0 :
getstatic java/lang/System/out Ljava/io/PrintStream
aload_0
getfield SecondClass/b [I
invokestatic java/util/Arrays.toString([I)Ljava/lang/String
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
new ThirdClass
dup
invokespecial ThirdClass/<init>()V
areturn
.end method
.method public method2()LThirdClass;
.limit stack 20
.limit locals 2
new ThirdClass
dup
invokespecial ThirdClass/<init>()V
areturn
.end method
