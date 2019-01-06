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
ldc 10
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
istore_3
BEGIN_WHILE_0 :
iload_3
iload_2
swap
if_icmple ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
ifeq END_WHILE_0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_1
iload_3
iaload
invokevirtual java/io/PrintStream/println(I)V
iload_3
ldc 1
iadd
istore_3
goto BEGIN_WHILE_0
END_WHILE_0 :
ldc 0
ireturn
.end method
.method public mergeSort([III)[I
.limit stack 24
.limit locals 6
iload_2
iload_3
swap
if_icmple ELSE1
ldc 1
goto END1
ELSE1 :
ldc 0
END1 :
ifeq ELSE_IF_0
iload_2
iload_3
iload_2
isub
ldc 2
idiv
iadd
istore_4
aload_0
aload_1
iload_2
iload_4
invokevirtual SecondClass/mergeSort([III)[I
astore_1
aload_0
aload_1
iload_4
ldc 1
iadd
iload_3
invokevirtual SecondClass/mergeSort([III)[I
astore_1
aload_0
aload_1
iload_2
iload_4
iload_3
invokevirtual SecondClass/merge([IIII)[I
astore_1
ELSE_IF_0 :
aload_1
areturn
.end method
.method public merge([IIII)[I
.limit stack 31
.limit locals 13
iload_3
iload_2
ldc 1
iadd
isub
istore_8
iload_4
iload_3
isub
istore_9
ldc 0
istore_5
ldc 0
istore_6
ldc 10
newarray int
astore_10
ldc 10
newarray int
astore_11
BEGIN_WHILE_1 :
iload_5
iload_8
swap
if_icmple ELSE2
ldc 1
goto END2
ELSE2 :
ldc 0
END2 :
ifeq END_WHILE_1
aload_10
iload_5
aload_1
iload_2
iload_5
iadd
iaload
iastore
iload_5
ldc 1
iadd
istore_5
goto BEGIN_WHILE_1
END_WHILE_1 :
BEGIN_WHILE_2 :
iload_6
iload_9
swap
if_icmple ELSE3
ldc 1
goto END3
ELSE3 :
ldc 0
END3 :
ifeq END_WHILE_2
aload_11
iload_6
aload_0
getfield SecondClass/arr [I
iload_3
ldc 1
iload_6
iadd
iadd
iaload
iastore
iload_6
ldc 1
iadd
istore_6
goto BEGIN_WHILE_2
END_WHILE_2 :
ldc 0
istore_5
ldc 0
istore_6
iload_2
istore_7
BEGIN_WHILE_3 :
iload_5
iload_8
swap
if_icmple ELSE4
ldc 1
goto END4
ELSE4 :
ldc 0
END4 :
ifeq ELSE5
iload_6
iload_9
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
aload_10
iload_5
iaload
aload_11
iload_6
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
aload_1
iload_7
aload_10
iload_5
iaload
iastore
iload_5
ldc 1
iadd
istore_5
goto END_IF_1
ELSE_IF_1 :
aload_1
iload_7
aload_11
iload_6
iaload
iastore
iload_6
ldc 1
iadd
istore_6
END_IF_1 :
iload_7
ldc 1
iadd
istore_7
goto BEGIN_WHILE_3
END_WHILE_3 :
BEGIN_WHILE_4 :
iload_5
iload_8
swap
if_icmple ELSE8
ldc 1
goto END8
ELSE8 :
ldc 0
END8 :
ifeq END_WHILE_4
aload_1
iload_7
aload_10
iload_5
iaload
iastore
iload_5
ldc 1
iadd
istore_5
iload_7
ldc 1
iadd
istore_7
goto BEGIN_WHILE_4
END_WHILE_4 :
BEGIN_WHILE_5 :
iload_6
iload_9
swap
if_icmple ELSE9
ldc 1
goto END9
ELSE9 :
ldc 0
END9 :
ifeq END_WHILE_5
aload_1
iload_7
aload_11
iload_6
iaload
iastore
iload_6
ldc 1
iadd
istore_6
iload_7
ldc 1
iadd
istore_7
goto BEGIN_WHILE_5
END_WHILE_5 :
BEGIN_WHILE_6 :
iload_6
iload_9
swap
if_icmple ELSE10
ldc 1
goto END10
ELSE10 :
ldc 0
END10 :
ifeq END_WHILE_6
aload_1
iload_7
aload_11
iload_6
iaload
iastore
iload_6
ldc 1
iadd
istore_6
iload_7
ldc 1
iadd
istore_7
goto BEGIN_WHILE_6
END_WHILE_6 :
aload_1
areturn
.end method
