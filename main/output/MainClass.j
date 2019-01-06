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
new Tataloo
dup
invokespecial Tataloo/<init>()V
ldc 12
ldc "s"
<<<<<<< HEAD
ldc 1
=======
ldc 2
>>>>>>> 4f7ed848764a6a0587ff32c6678c4d5c25678890
invokevirtual Tataloo/sex(ILjava/lang/String;I)I
invokevirtual java/io/PrintStream/println(I)V
ldc 0
ireturn
.end method
