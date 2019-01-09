.class public X
.super Y
.field protected i I = 0
.method public <init>()V
aload_0
invokespecial Y/<init>()V
return
.end method
.method public setI(I)I
.limit stack 21
.limit locals 3
aload_0
ldc ""
aload_0
ldc ""
aload_0
ldc ""
putfield X/secret Ljava/lang/String;
iload 1
istore 1
iload 1
ireturn
.end method
.method public getI()I
.limit stack 20
.limit locals 2
aload_0
getfield X/i I
ireturn
.end method
.method public getParentSecret()Ljava/lang/String;
.limit stack 20
.limit locals 2
aload_0
getfield X/secret Ljava/lang/String;
areturn
.end method
.method public getSecret()Ljava/lang/String;
.limit stack 20
.limit locals 2
aload_0
getfield X/secret Ljava/lang/String;
areturn
.end method
