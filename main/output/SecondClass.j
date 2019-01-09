.class public SecondClass
.super Object
.field protected arr_size I
.field protected array [I
.field protected array2 [I
.field protected temp I
.method public <init>()V
aload_0
invokespecial Object/<init>()V
return
.end method
.method public method()I
.limit stack 20
.limit locals 2
aload_0
ldc 6
newarray int
putfield SecondClass/array [I
aload_0
ldc 6
newarray int
putfield SecondClass/array2 [I
aload_0
getfield SecondClass/array [I
ldc 0
ldc 12
iastore
aload_0
getfield SecondClass/array [I
ldc 1
ldc 11
iastore
aload_0
getfield SecondClass/array [I
ldc 2
ldc 13
iastore
aload_0
getfield SecondClass/array [I
ldc 3
ldc 5
iastore
aload_0
getfield SecondClass/array [I
ldc 4
ldc 6
iastore
aload_0
getfield SecondClass/array [I
ldc 5
ldc 7
iastore
aload_0
aload_0
getfield SecondClass/array [I
arraylength
putfield SecondClass/arr_size I
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Given array is"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
aload_0
aload_0
getfield SecondClass/arr_size I
invokevirtual SecondClass/printArray(I)I
putfield SecondClass/temp I
aload_0
aload_0
ldc 0
aload_0
getfield SecondClass/array [I
arraylength
ldc 1
isub
invokevirtual SecondClass/mergeSort(II)[I
putfield SecondClass/array2 [I
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Sorted array is"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload_0
aload_0
aload_0
getfield SecondClass/arr_size I
invokevirtual SecondClass/printArray(I)I
putfield SecondClass/temp I
ldc 0
ireturn
.end method
.method public printArray(I)I
.limit stack 22
.limit locals 4
ldc 0
istore 2
BEGIN_WHILE_0 :
iload 2
iload 1
swap
if_icmple ELSE0
ldc 1
goto END0
ELSE0 :
ldc 0
END0 :
ifeq END_WHILE_0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_0
getfield SecondClass/array [I
iload 2
iaload
invokevirtual java/io/PrintStream/println(I)V
iload 2
ldc 1
iadd
istore 2
goto BEGIN_WHILE_0
END_WHILE_0 :
ldc 0
ireturn
.end method
.method public mergeSort(II)[I
.limit stack 25
.limit locals 7
ldc 6
newarray int
astore 5
iload 1
iload 2
swap
if_icmple ELSE1
ldc 1
goto END1
ELSE1 :
ldc 0
END1 :
ifeq ELSE_IF_0
iload 1
iload 2
iload 1
isub
ldc 2
idiv
iadd
istore 3
aload_0
iload 1
iload 3
invokevirtual SecondClass/mergeSort(II)[I
astore 5
aload_0
iload 3
ldc 1
iadd
iload 2
invokevirtual SecondClass/mergeSort(II)[I
astore 5
aload_0
iload 1
iload 3
iload 2
invokevirtual SecondClass/merge(III)[I
astore 5
ELSE_IF_0 :
aload 5
areturn
.end method
.method public merge(III)[I
.limit stack 31
.limit locals 13
iload 2
iload 1
isub
ldc 1
iadd
istore 7
iload 3
iload 2
isub
istore 8
ldc 0
istore 4
ldc 0
istore 5
ldc 10
newarray int
astore 9
ldc 10
newarray int
astore 10
BEGIN_WHILE_1 :
iload 4
iload 7
swap
if_icmple ELSE2
ldc 1
goto END2
ELSE2 :
ldc 0
END2 :
ifeq END_WHILE_1
aload 9
iload 4
aload_0
getfield SecondClass/array [I
iload 1
iload 4
iadd
iaload
iastore
iload 4
ldc 1
iadd
istore 4
goto BEGIN_WHILE_1
END_WHILE_1 :
BEGIN_WHILE_2 :
iload 5
iload 8
swap
if_icmple ELSE3
ldc 1
goto END3
ELSE3 :
ldc 0
END3 :
ifeq END_WHILE_2
aload 10
iload 5
aload_0
getfield SecondClass/array [I
iload 2
ldc 1
iadd
iload 5
iadd
iaload
iastore
iload 5
ldc 1
iadd
istore 5
goto BEGIN_WHILE_2
END_WHILE_2 :
ldc 0
istore 4
ldc 0
istore 5
iload 1
istore 6
BEGIN_WHILE_3 :
iload 4
iload 7
swap
if_icmple ELSE4
ldc 1
goto END4
ELSE4 :
ldc 0
END4 :
ifeq ELSE5
iload 5
iload 8
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
aload 9
iload 4
iaload
aload 10
iload 5
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
aload_0
getfield SecondClass/array [I
iload 6
aload 9
iload 4
iaload
iastore
iload 4
ldc 1
iadd
istore 4
goto END_IF_1
ELSE_IF_1 :
aload_0
getfield SecondClass/array [I
iload 6
aload 10
iload 5
iaload
iastore
iload 5
ldc 1
iadd
istore 5
END_IF_1 :
iload 6
ldc 1
iadd
istore 6
goto BEGIN_WHILE_3
END_WHILE_3 :
BEGIN_WHILE_4 :
iload 4
iload 7
swap
if_icmple ELSE8
ldc 1
goto END8
ELSE8 :
ldc 0
END8 :
ifeq END_WHILE_4
aload_0
getfield SecondClass/array [I
iload 6
aload 9
iload 4
iaload
iastore
iload 4
ldc 1
iadd
istore 4
iload 6
ldc 1
iadd
istore 6
goto BEGIN_WHILE_4
END_WHILE_4 :
BEGIN_WHILE_5 :
iload 5
iload 8
swap
if_icmple ELSE9
ldc 1
goto END9
ELSE9 :
ldc 0
END9 :
ifeq END_WHILE_5
aload_0
getfield SecondClass/array [I
iload 6
aload 10
iload 5
iaload
iastore
iload 5
ldc 1
iadd
istore 5
iload 6
ldc 1
iadd
istore 6
goto BEGIN_WHILE_5
END_WHILE_5 :
aload_0
getfield SecondClass/array2 [I
areturn
.end method
