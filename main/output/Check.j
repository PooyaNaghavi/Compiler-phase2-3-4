.class public Check
.super Object
.method public <init>()V
aload_0
invokespecial Object/<init>()V
return
.end method
.method public main()I
.limit stack 21
.limit locals 3
ldc 
astore 1
ldc "2"
astore 1
aload 1
ldc ""
if_acmpne ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
ifeq ELSE_IF_0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 1
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ELSE_IF_0 :
ldc 0
ireturn
.end method
