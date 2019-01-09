.class public Node
.super Object
.field protected hasNext Z = 0
.field protected next LNode;
.field protected data I = 0
.method public <init>()V
aload_0
invokespecial Object/<init>()V
return
.end method
.method public constructor()I
.limit stack 20
.limit locals 2
aload_0
ldc ""
aload_0
ldc ""
aload_0
ldc ""
aload_0
ldc 0
putfield Node/hasNext Z
aload_0
aload_0
putfield Node/next LNode;
aload_0
ldc 1
ineg
putfield Node/data I
ldc 0
ireturn
.end method
.method public setData(I)I
.limit stack 21
.limit locals 3
aload_0
iload 1
putfield Node/data I
ldc 0
ireturn
.end method
.method public getData()I
.limit stack 20
.limit locals 2
aload_0
getfield Node/data I
ireturn
.end method
.method public setNextNode(LNode;)I
.limit stack 21
.limit locals 3
aload_0
aload 1
putfield Node/next LNode;
aload_0
ldc 1
putfield Node/hasNext Z
ldc 0
ireturn
.end method
.method public unSetNext()I
.limit stack 20
.limit locals 2
aload_0
ldc 0
putfield Node/hasNext Z
ldc 0
ireturn
.end method
.method public hasNext()Z
.limit stack 20
.limit locals 2
aload_0
getfield Node/hasNext Z
ireturn
.end method
.method public getNext()LNode;
.limit stack 20
.limit locals 2
aload_0
getfield Node/next LNode;
areturn
.end method
