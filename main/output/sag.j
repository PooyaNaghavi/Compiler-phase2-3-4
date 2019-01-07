.class public sag
.super java/lang/Object
.field protected ff Lsag;
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public sex1(I)I
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
iload 1
ldc 10
imul
ldc 23
iadd
istore 1
ldc 10
newarray int
astore 3
aload 3
ldc 9
ldc 10
iastore
aload_0
new sag
dup
invokespecial sag/<init>()V
putfield sag/ff Lsag;
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield sag/ff Lsag;
ldc 10
invokevirtual sag/sex3(I)I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 3
arraylength
invokevirtual java/io/PrintStream/println(I)V
ldc 1
ireturn
.end method
.method public sex2(I)Lsag;
.limit stack 21
.limit locals 3
new sag
dup
invokespecial sag/<init>()V
areturn
.end method
.method public sex3(I)I
.limit stack 21
.limit locals 3
ldc 111
ireturn
.end method
