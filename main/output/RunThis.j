.class public RunThis
.super Object
.method public <init>()V
aload_0
invokespecial Object/<init>()V
return
.end method
.method public main()I
.limit stack 20
.limit locals 2
new XXX
dup
invokespecial XXX/<init>()V
invokevirtual XXX/ss()I
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
invokevirtual RunThis/toString()Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ldc 0
ireturn
.end method
