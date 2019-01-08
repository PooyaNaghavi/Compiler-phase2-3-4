.class public sag
.super java/lang/Object
.field protected ff Lsag;
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public sex1(I)I
.limit stack 29
.limit locals 11
ldc "ali0"
astore 2
ldc 1
ldc 0
if_icmpne ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
istore 7
iload 1
ldc 10
iadd
ldc 2
iadd
istore 1
aload_0
new sag
dup
invokespecial sag/<init>()V
putfield sag/ff Lsag;
ldc 10
newarray int
astore 3
aload 3
ldc 9
ldc 10
new sag
dup
invokespecial sag/<init>()V
ldc 20
invokevirtual sag/sex2(I)Lsag;
ldc 10
invokevirtual sag/sex3(I)I
iadd
iastore
ldc 1
aload 3
ldc 9
iaload
iadd
istore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 3
arraylength
iload 1
iadd
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 4
new sag
dup
invokespecial sag/<init>()V
ldc 20
invokevirtual sag/sex2(I)Lsag;
ldc 10
invokevirtual sag/sex3(I)I
iadd
aload 3
arraylength
iadd
iload 1
iadd
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 3
arraylength
invokevirtual java/io/PrintStream/println(I)V
iload 1
ireturn
.end method
.method public sex2(I)Lsag;
.limit stack 23
.limit locals 5
ldc "ali0"
astore 2
iload 1
ldc 10
iadd
ldc 2
iadd
istore 1
aload_0
new sag
dup
invokespecial sag/<init>()V
putfield sag/ff Lsag;
ldc 10
newarray int
astore 3
aload 3
ldc 9
ldc 10
iastore
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 3
arraylength
invokevirtual java/io/PrintStream/println(I)V
ldc 1
aload 3
ldc 9
iaload
iadd
istore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 3
arraylength
invokevirtual java/io/PrintStream/println(I)V
new sag
dup
invokespecial sag/<init>()V
areturn
.end method
.method public sex3(I)I
.limit stack 21
.limit locals 3
iload 1
ireturn
.end method
