.class public LinkedList
.super Object
.field protected head LNode;
.field protected tmp I = 0
.method public <init>()V
.limit stack 2
aload_0
invokespecial Object/<init>()V
return
.end method
.method public constructor()I
.limit stack 20
.limit locals 2
aload_0
new Node
dup
invokespecial Node/<init>()V
putfield LinkedList/head LNode;
aload_0
aload_0
getfield LinkedList/head LNode;
invokevirtual Node/constructor()I
putfield LinkedList/tmp I
ldc 0
ireturn
.end method
.method public getLastNode()LNode;
.limit stack 21
.limit locals 3
aload_0
getfield LinkedList/head LNode;
astore 1
BEGIN_WHILE_5 :
aload 1
invokevirtual Node/hasNext()Z
ifeq END_WHILE_5
aload 1
invokevirtual Node/getNext()LNode;
astore 1
goto BEGIN_WHILE_5
END_WHILE_5 :
aload 1
areturn
.end method
.method public push(I)I
.limit stack 23
.limit locals 5
new Node
dup
invokespecial Node/<init>()V
astore 2
aload_0
aload 2
invokevirtual Node/constructor()I
putfield LinkedList/tmp I
aload_0
aload 2
iload 1
invokevirtual Node/setData(I)I
putfield LinkedList/tmp I
aload_0
aload_0
invokevirtual LinkedList/getLastNode()LNode;
aload 2
invokevirtual Node/setNextNode(LNode;)I
putfield LinkedList/tmp I
ldc 0
ireturn
.end method
.method public printAllNode()I
.limit stack 21
.limit locals 3
aload_0
getfield LinkedList/head LNode;
astore 1
BEGIN_WHILE_6 :
aload 1
invokevirtual Node/hasNext()Z
ifeq END_WHILE_6
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 1
invokevirtual Node/getData()I
invokevirtual java/io/PrintStream/println(I)V
aload 1
invokevirtual Node/getNext()LNode;
astore 1
goto BEGIN_WHILE_6
END_WHILE_6 :
ldc 0
ireturn
.end method
