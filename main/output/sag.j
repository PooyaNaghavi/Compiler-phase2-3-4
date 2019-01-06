.class public sag
.super java/lang/Object
.field protected ff Lsag;
.field protected p [I
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public sex1(I)I
.limit stack 21
.limit locals 3
aload_0
ldc 2
newarray int
putfield sag/p [I
aload_0
getfield sag/p [I
ldc 0
ldc 1
iastore
aload_0
getfield sag/p [I
ldc 1
ldc 1
iastore
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield sag/p [I
invokevirtual java/io/PrintStream/println([I)V
ldc 10
ireturn
.end method
