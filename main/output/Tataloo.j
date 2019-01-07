.class public Tataloo
.super sag
.method public <init>()V
aload_0
invokespecial sag/<init>()V
return
.end method
.method public sex(ILjava/lang/String;I)I
.limit stack 23
.limit locals 5
getstatic java/lang/System/out Ljava/io/PrintStream;
new sag
dup
invokespecial sag/<init>()V
ldc 12
invokevirtual sag/sex1(I)I
invokevirtual java/io/PrintStream/println(I)V
ldc 10
ireturn
.end method
