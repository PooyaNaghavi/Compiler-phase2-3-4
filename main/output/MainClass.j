.class public MainClass
.super java/lang/Object
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public main()I
.limit stack 20
.limit locals 2
getstatic java/lang/System/out Ljava/io/PrintStream;
new sag
dup
invokespecial sag/<init>()V
ldc 12
invokevirtual sag/sex1(I)I
invokevirtual java/io/PrintStream/println(I)V
ldc 0
ireturn
.end method
