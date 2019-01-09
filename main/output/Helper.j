.class public Helper
.super Object
.field protected b Z = 0
.field protected i I = 0
.field protected s Ljava/lang/String; = " "
.field protected a [I
.field protected x LX;
.field protected tmp I = 0
.method public <init>()V
.limit stack 2
aload_0
invokespecial Object/<init>()V
aload_0
ldc ""
putfield Helper/s Ljava/lang/String;
return
.end method
.method public pow(II)I
.limit stack 23
.limit locals 5
ldc 0
istore 3
iload 2
ldc 0
if_icmpne ELSE13
ldc 1
goto END13
ELSE13 :
ldc 0
END13 :
ifeq ELSE_IF_5
ldc 1
istore 3
ELSE_IF_5 :
iload 2
ldc 1
if_icmpne ELSE14
ldc 1
goto END14
ELSE14 :
ldc 0
END14 :
ifeq ELSE_IF_6
iload 1
istore 3
goto END_IF_6
ELSE_IF_6 :
aload_0
iload 1
iload 2
ldc 1
isub
invokevirtual Helper/pow(II)I
istore 3
END_IF_6 :
iload 3
ireturn
.end method
.method public someFunc(II)I
.limit stack 22
.limit locals 4
ldc 231
iload 2
iload 1
iload 2
imul
iadd
ldc 1
iadd
idiv
ldc 1
iadd
istore 1
ldc 234
iload 2
ldc 1
iadd
idiv
iload 2
ldc 1
iadd
idiv
iload 2
ldc 1
iadd
idiv
istore 2
iload 2
iload 2
ldc 1
iadd
idiv
ireturn
.end method
.method public changeAll2(II)I
.limit stack 23
.limit locals 5
ldc 0
istore 3
aload_0
aload_0
ldc 31
ldc 3123
invokevirtual Helper/someFunc(II)I
putfield Helper/tmp I
aload_0
ldc 100
newarray int
putfield Helper/a [I
ldc 0
istore 3
BEGIN_WHILE_2 :
iload 3
iload 1
swap
if_icmple ELSE15
ldc 1
goto END15
ELSE15 :
ldc 0
END15 :
ifeq END_WHILE_2
aload_0
getfield Helper/a [I
iload 3
iload 3
iload 2
imul
iload 1
iadd
iastore
iload 3
ldc 1
iadd
istore 3
goto BEGIN_WHILE_2
END_WHILE_2 :
ldc 0
istore 3
BEGIN_WHILE_3 :
iload 3
iload 1
ldc 1
isub
swap
if_icmple ELSE16
ldc 1
goto END16
ELSE16 :
ldc 0
END16 :
ifeq END_WHILE_3
aload_0
getfield Helper/a [I
iload 3
aload_0
getfield Helper/a [I
iload 3
ldc 1
iadd
iaload
ldc 100
iadd
iload 1
iadd
iastore
iload 3
ldc 2
iadd
istore 3
goto BEGIN_WHILE_3
END_WHILE_3 :
ldc 1
istore 3
BEGIN_WHILE_4 :
iload 3
iload 1
swap
if_icmple ELSE17
ldc 1
goto END17
ELSE17 :
ldc 0
END17 :
ifeq END_WHILE_4
aload_0
getfield Helper/a [I
iload 3
ldc 2
idiv
aload_0
getfield Helper/a [I
iload 3
ldc 1
isub
iaload
iastore
iload 3
ldc 1
iadd
istore 3
goto BEGIN_WHILE_4
END_WHILE_4 :
ldc 0
ireturn
.end method
.method public changeAll(IILjava/lang/String;)I
.limit stack 23
.limit locals 5
aload_0
ldc 1
putfield Helper/b Z
aload_0
ldc 10001
putfield Helper/i I
aload_0
aload 3
putfield Helper/s Ljava/lang/String;
aload_0
ldc 150
newarray int
putfield Helper/a [I
aload_0
getfield Helper/a [I
ldc 0
iload 1
iload 2
iadd
iastore
aload_0
getfield Helper/a [I
ldc 10
iload 1
iload 2
idiv
iastore
aload_0
getfield Helper/a [I
ldc 100
iload 1
iload 2
isub
ldc 2
aload_0
getfield Helper/a [I
ldc 10
iaload
iadd
ldc 100
isub
iadd
ldc 34
ldc 3
idiv
iadd
iastore
aload_0
getfield Helper/a [I
ldc 2
aload_0
getfield Helper/a [I
ldc 0
iaload
aload_0
getfield Helper/a [I
ldc 1
iaload
aload_0
getfield Helper/a [I
ldc 100
iaload
imul
iadd
iastore
aload_0
new X
dup
invokespecial X/<init>()V
putfield Helper/x LX;
aload_0
aload_0
getfield Helper/x LX;
ldc 50
ineg
invokevirtual X/setI(I)I
putfield Helper/tmp I
iload 1
ireturn
.end method
.method public printAll()Ljava/lang/String;
.limit stack 20
.limit locals 2
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "------------"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield Helper/a [I
arraylength
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 3
ldc 3
iadd
ldc 5
ldc 6
imul
ldc 7
idiv
isub
aload_0
getfield Helper/a [I
ldc 3
iaload
aload_0
getfield Helper/a [I
ldc 4
iaload
aload_0
getfield Helper/i I
imul
aload_0
getfield Helper/i I
iadd
idiv
iadd
ldc 1
iadd
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield Helper/a [I
invokestatic java/util/Arrays.toString([I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
ldc 12
ldc 6
invokevirtual Helper/pow(II)I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 10
newarray int
ldc 5
iaload
ldc 32
idiv
invokevirtual java/io/PrintStream/println(I)V
aload_0
new X
dup
invokespecial X/<init>()V
putfield Helper/x LX;
aload_0
aload_0
getfield Helper/x LX;
ldc 1000
invokevirtual X/setI(I)I
putfield Helper/tmp I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield Helper/x LX;
invokevirtual X/getI()I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield Helper/i I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield Helper/s Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield Helper/a [I
invokestatic java/util/Arrays.toString([I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
invokevirtual Helper/toString()Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
aload_0
getfield Helper/i I
ineg
putfield Helper/i I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield Helper/i I
invokevirtual java/io/PrintStream/println(I)V
aload_0
getfield Helper/b Z
ifeq ELSE_IF_7
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "true"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto END_IF_7
ELSE_IF_7 :
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "false"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
END_IF_7 :
aload_0
aload_0
getfield Helper/i I
aload_0
getfield Helper/i I
ldc 34
idiv
iadd
putfield Helper/i I
aload_0
ldc "fsdffs"
putfield Helper/s Ljava/lang/String;
aload_0
aload_0
getfield Helper/x LX;
invokevirtual X/toString()Ljava/lang/String;
putfield Helper/s Ljava/lang/String;
aload_0
ldc 100
newarray int
putfield Helper/a [I
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "this is a block!"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ldc "ok"
areturn
.end method
.method public getArray()[I
.limit stack 20
.limit locals 2
aload_0
getfield Helper/a [I
areturn
.end method
