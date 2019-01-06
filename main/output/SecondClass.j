.class public SecondClass
.super java/lang/Object
.field protected arr [I
.field protected arr_size I
.field protected temp I
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public method()I
.limit stack 20
.limit locals 2
aload_0
ldc 6
newarray int
putfield SecondClass/arr [I
aload_0
getfield SecondClass/arr [I
ldc 0
ldc 12
iastore
aload_0
getfield SecondClass/arr [I
ldc 1
ldc 11
iastore
aload_0
getfield SecondClass/arr [I
ldc 2
ldc 13
iastore
aload_0
getfield SecondClass/arr [I
ldc 3
ldc 5
iastore
aload_0
getfield SecondClass/arr [I
ldc 4
ldc 6
iastore
aload_0
getfield SecondClass/arr [I
ldc 5
ldc 7
iastore
aload_0
ldc 6
putfield SecondClass/arr_size I
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Given array is"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
aload_0
aload_0
getfield SecondClass/arr [I
aload_0
getfield SecondClass/arr_size I
invokevirtual SecondClass/printArray([II)I
putfield SecondClass/temp I
aload_0
aload_0
aload_0
getfield SecondClass/arr [I
ldc 0
aload_0
getfield SecondClass/arr_size I
ldc 1
isub
invokevirtual SecondClass/mergeSort([III)[I
putfield SecondClass/arr [I
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Sorted array is"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
aload_0
aload_0
getfield SecondClass/arr [I
aload_0
getfield SecondClass/arr_size I
invokevirtual SecondClass/printArray([II)I
putfield SecondClass/temp I
ldc 0
ireturn
.end method
.method public printArray([II)I
.limit stack 23
.limit locals 5
ldc 0
istore 3
BEGIN_WHILE_0 :
iload 3
iload 2
swap
if_icmple ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
ifeq END_WHILE_0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 1
iload 3
iaload
invokevirtual java/io/PrintStream/println(I)V
iload 3
ldc 1
iadd
istore 3
goto BEGIN_WHILE_0
END_WHILE_0 :
ldc 0
ireturn
.end method
.method public mergeSort([III)[I
.limit stack 24
.limit locals 6
iload 2
iload 3
swap
if_icmple ELSE1
ldc 1
goto END1
ELSE1 :
ldc 0
END1 :
ifeq ELSE_IF_0
iload 2
iload 3
iload 2
isub
ldc 2
idiv
iadd
istore 4
aload_0
aload 1
iload 2
iload 4
invokevirtual SecondClass/mergeSort([III)[I
astore 1
aload_0
aload 1
iload 4
ldc 1
iadd
iload 3
invokevirtual SecondClass/mergeSort([III)[I
astore 1
aload_0
aload 1
iload 2
iload 4
iload 3
invokevirtual SecondClass/merge([IIII)[I
astore 1
ELSE_IF_0 :
aload 1
areturn
.end method
.method public merge([IIII)[I
.limit stack 31
.limit locals 13
iload 3
iload 2
ldc 1
iadd
isub
istore 8
iload 4
iload 3
isub
istore 9
ldc 0
istore 5
ldc 0
istore 6
ldc 10
newarray int
astore 10
ldc 10
newarray int
astore 11
BEGIN_WHILE_1 :
iload 5
iload 8
swap
if_icmple ELSE2
ldc 1
goto END2
ELSE2 :
ldc 0
END2 :
ifeq END_WHILE_1
aload 10
iload 5
aload 1
iload 2
iload 5
iadd
iaload
iastore
iload 5
ldc 1
iadd
istore 5
goto BEGIN_WHILE_1
END_WHILE_1 :
BEGIN_WHILE_2 :
iload 6
iload 9
swap
if_icmple ELSE3
ldc 1
goto END3
ELSE3 :
ldc 0
END3 :
ifeq END_WHILE_2
aload 11
iload 6
aload_0
getfield SecondClass/arr [I
iload 3
ldc 1
iload 6
iadd
iadd
iaload
iastore
iload 6
ldc 1
iadd
istore 6
goto BEGIN_WHILE_2
END_WHILE_2 :
ldc 0
istore 5
ldc 0
istore 6
iload 2
istore 7
BEGIN_WHILE_3 :
iload 5
iload 8
swap
if_icmple ELSE4
ldc 1
goto END4
ELSE4 :
ldc 0
END4 :
ifeq ELSE5
iload 6
iload 9
swap
if_icmple ELSE5
ldc 1
goto END5
ELSE5 :
ldc 0
END5 :
ifeq ELSE6
ldc 1
goto END6
ELSE6 :
ldc 0
END6 :
ifeq END_WHILE_3
aload 10
iload 5
iaload
aload 11
iload 6
iaload
ldc 1
iadd
swap
if_icmple ELSE7
ldc 1
goto END7
ELSE7 :
ldc 0
END7 :
ifeq ELSE_IF_1
aload 1
iload 7
aload 10
iload 5
iaload
iastore
iload 5
ldc 1
iadd
istore 5
goto END_IF_1
ELSE_IF_1 :
aload 1
iload 7
aload 11
iload 6
iaload
iastore
iload 6
ldc 1
iadd
istore 6
END_IF_1 :
iload 7
ldc 1
iadd
istore 7
goto BEGIN_WHILE_3
END_WHILE_3 :
BEGIN_WHILE_4 :
iload 5
iload 8
swap
if_icmple ELSE8
ldc 1
goto END8
ELSE8 :
ldc 0
END8 :
ifeq END_WHILE_4
aload 1
iload 7
aload 10
iload 5
iaload
iastore
iload 5
ldc 1
iadd
istore 5
iload 7
ldc 1
iadd
istore 7
goto BEGIN_WHILE_4
END_WHILE_4 :
aload 1
areturn
.end method
