.class public JavaMain
.super java/lang/Object
.method public <init>()V
aload_0 ; push this
invokespecial java/lang/Object/<init>()V ; call super
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 2
new RunThis 
dup
invokespecial RunThis/<init>()V
invokevirtual RunThis/main()I
return
.end method

