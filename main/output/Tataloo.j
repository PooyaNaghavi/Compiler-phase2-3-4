.class public Tataloo
.super sag
.field protected xx LMainClass;
.method public <init>()V
aload_0
invokespecial sag/<init>()V
return
.end method
.method public sex(ILjava/lang/String;I)I
.limit stack 24
.limit locals 6
new sag
dup
invokespecial sag/<init>()V
ldc 2
invokevirtual sag/sex1(I)I
istore 3
aload_0
new MainClass
dup
invokespecial MainClass/<init>()V
putfield Tataloo/xx LMainClass;
new sag
dup
invokespecial sag/<init>()V
invokevirtual sag/sex2()Z
astore 4
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 10
ldc 33
iadd
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
new sag
dup
invokespecial sag/<init>()V
ldc 2
invokevirtual sag/sex1(I)I
invokevirtual java/io/PrintStream/println(I)V
ldc 10
ireturn
.end method
