.class public Y
.super Object
.field protected secret Ljava/lang/String; = " "
.method public <init>()V
.limit stack 2
aload_0
invokespecial Object/<init>()V
aload_0
ldc ""
putfield Y/secret Ljava/lang/String;
return
.end method
.method public changeSecret(Ljava/lang/String;)I
.limit stack 21
.limit locals 3
aload_0
aload 1
putfield Y/secret Ljava/lang/String;
ldc 0
ireturn
.end method
