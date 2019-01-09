.class public XXX
.super Object
.field protected a Z
.field protected b Z
.field protected c I
.field protected d Ljava/lang/String;
.field protected k I
.method public <init>()V
aload_0
invokespecial Object/<init>()V
return
.end method
.method public ss()I
.limit stack 23
.limit locals 5
new Helper
dup
invokespecial Helper/<init>()V
astore 1
new LinkedList
dup
invokespecial LinkedList/<init>()V
astore 3
aload_0
aload 3
invokevirtual LinkedList/constructor()I
putfield XXX/k I
ldc "a"
ldc "a"
if_acmpeq ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
ifeq ELSE_IF_0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "ok"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto END_IF_0
ELSE_IF_0 :
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "nnoooooo"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
END_IF_0 :
aload_0
getfield XXX/c I
ldc 100
if_icmple ELSE1
ldc 1
goto END1
ELSE1 :
ldc 0
END1 :
ifeq ELSE2
aload 1
ldc 10
ldc 20
ldc "salam"
invokevirtual Helper/changeAll(IILjava/lang/String;)I
ldc 0
if_icmple ELSE2
ldc 1
goto END2
ELSE2 :
ldc 0
END2 :
ifeq ELSE3
aload 1
invokevirtual Helper/printAll()Ljava/lang/String;
ldc "KHERS"
if_acmpeq ELSE3
ldc 1
goto END3
ELSE3 :
ldc 0
END3 :
ifeq ELSE4
ldc 1
goto END4
ELSE4 :
ldc 0
END4 :
ifeq ELSE5
ldc 1
goto END5
ELSE5 :
ldc 0
END5 :
ifeq ELSE_IF_1
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "xxxxxxxxxxxxxxx"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ELSE_IF_1 :
aload 1
ldc 10
ineg
ldc 20
ldc "salam"
invokevirtual Helper/changeAll(IILjava/lang/String;)I
ldc 0
if_icmple ELSE6
ldc 1
goto END6
ELSE6 :
ldc 0
END6 :
ifeq ELSE7
aload 1
invokevirtual Helper/printAll()Ljava/lang/String;
ldc "KHERS"
if_acmpeq ELSE7
ldc 1
goto END7
ELSE7 :
ldc 0
END7 :
ifeq ELSE8
ldc 1
goto END8
ELSE8 :
ldc 0
END8 :
ifeq ELSE_IF_2
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "yyyyyyyyyyyy"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ELSE_IF_2 :
aload_0
aload 1
ldc 1000
ldc 20
ineg
aload_0
invokevirtual XXX/toString()Ljava/lang/String;
invokevirtual Helper/changeAll(IILjava/lang/String;)I
putfield XXX/k I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 1
invokevirtual Helper/printAll()Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
ldc 0
putfield XXX/c I
BEGIN_WHILE_0 :
aload_0
getfield XXX/c I
ldc 10
swap
if_icmple ELSE9
ldc 1
goto END9
ELSE9 :
ldc 0
END9 :
ifeq END_WHILE_0
aload_0
getfield XXX/c I
ldc 5
swap
if_icmple ELSE10
ldc 1
goto END10
ELSE10 :
ldc 0
END10 :
ifeq ELSE_IF_3
aload_0
ldc "salaaam 1"
putfield XXX/d Ljava/lang/String;
goto END_IF_3
ELSE_IF_3 :
aload_0
getfield XXX/c I
ldc 10
if_icmple ELSE11
ldc 1
goto END11
ELSE11 :
ldc 0
END11 :
ifeq ELSE_IF_3
aload_0
ldc "hello!"
putfield XXX/d Ljava/lang/String;
goto END_IF_3
ELSE_IF_3 :
aload_0
ldc "khers!"
putfield XXX/d Ljava/lang/String;
END_IF_3 :
END_IF_4 :
aload_0
aload 1
aload_0
getfield XXX/c I
aload_0
getfield XXX/c I
ldc 10
iadd
aload_0
getfield XXX/d Ljava/lang/String;
invokevirtual Helper/changeAll(IILjava/lang/String;)I
putfield XXX/k I
aload_0
aload 1
invokevirtual Helper/printAll()Ljava/lang/String;
putfield XXX/d Ljava/lang/String;
aload_0
aload_0
getfield XXX/c I
ldc 1
iadd
putfield XXX/c I
goto BEGIN_WHILE_0
END_WHILE_0 :
new X
dup
invokespecial X/<init>()V
astore 2
aload_0
aload 2
ldc "this is secret!"
invokevirtual X/changeSecret(Ljava/lang/String;)I
putfield XXX/k I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokevirtual X/getSecret()Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
ldc 0
putfield XXX/c I
BEGIN_WHILE_1 :
aload_0
getfield XXX/c I
ldc 10
swap
if_icmple ELSE12
ldc 1
goto END12
ELSE12 :
ldc 0
END12 :
ifeq END_WHILE_1
aload_0
aload 1
aload_0
getfield XXX/c I
ldc 10
iadd
ldc 10
invokevirtual Helper/changeAll2(II)I
putfield XXX/k I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 1
invokevirtual Helper/getArray()[I
invokestatic java/util/Arrays.toString([I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
aload_0
getfield XXX/c I
ldc 1
iadd
putfield XXX/c I
goto BEGIN_WHILE_1
END_WHILE_1 :
aload_0
aload 3
invokevirtual LinkedList/printAllNode()I
putfield XXX/k I
aload_0
aload 3
ldc 1
invokevirtual LinkedList/push(I)I
putfield XXX/k I
aload_0
aload 3
ldc 10
invokevirtual LinkedList/push(I)I
putfield XXX/k I
aload_0
aload 3
ldc 100
invokevirtual LinkedList/push(I)I
putfield XXX/k I
aload_0
aload 3
ldc 1000
invokevirtual LinkedList/push(I)I
putfield XXX/k I
aload_0
aload 3
ldc 10000
invokevirtual LinkedList/push(I)I
putfield XXX/k I
aload_0
aload 3
ldc 100000
invokevirtual LinkedList/push(I)I
putfield XXX/k I
aload_0
aload 3
ldc 1000000
invokevirtual LinkedList/push(I)I
putfield XXX/k I
aload_0
aload 3
invokevirtual LinkedList/printAllNode()I
putfield XXX/k I
ldc 11
ireturn
.end method
