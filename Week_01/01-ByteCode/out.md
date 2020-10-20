```
$ javac -g 01-ByteCode/src/Hello.java
$ javap -c -v 01-ByteCode.src.Hello
警告: 二进制文件01-ByteCode.src.Hello包含Hello
Classfile /Users/kaito/geek-edu/JAVA-000/Week_01/01-ByteCode/src/Hello.class
  Last modified 2020-10-20; size 1267 bytes
  MD5 checksum 8965aeef4b1663ecc14b408960a2d996
  Compiled from "Hello.java"
public class Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #20.#49        // java/lang/Object."<init>":()V
   #2 = Integer            20000000
   #3 = Long               300000000l
   #5 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
   #6 = Class              #52            // java/lang/StringBuilder
   #7 = Methodref          #6.#49         // java/lang/StringBuilder."<init>":()V
   #8 = String             #53            // a + b =
   #9 = Methodref          #6.#54         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #10 = Methodref          #6.#55         // java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
  #11 = Methodref          #6.#56         // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #12 = Methodref          #57.#58        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #13 = String             #59            // b / a =
  #14 = String             #60            // b - a =
  #15 = String             #61            // a * b =
  #16 = Float              0.01f
  #17 = String             #62            // ---this is split line---
  #18 = Methodref          #57.#63        // java/io/PrintStream.println:(F)V
  #19 = Class              #64            // Hello
  #20 = Class              #65            // java/lang/Object
  #21 = Utf8               <init>
  #22 = Utf8               ()V
  #23 = Utf8               Code
  #24 = Utf8               LineNumberTable
  #25 = Utf8               LocalVariableTable
  #26 = Utf8               this
  #27 = Utf8               LHello;
  #28 = Utf8               main
  #29 = Utf8               ([Ljava/lang/String;)V
  #30 = Utf8               i
  #31 = Utf8               I
  #32 = Utf8               f
  #33 = Utf8               F
  #34 = Utf8               args
  #35 = Utf8               [Ljava/lang/String;
  #36 = Utf8               a
  #37 = Utf8               b
  #38 = Utf8               J
  #39 = Utf8               z
  #40 = Utf8               Z
  #41 = Utf8               c
  #42 = Utf8               d
  #43 = Utf8               [F
  #44 = Utf8               StackMapTable
  #45 = Class              #35            // "[Ljava/lang/String;"
  #46 = Class              #43            // "[F"
  #47 = Utf8               SourceFile
  #48 = Utf8               Hello.java
  #49 = NameAndType        #21:#22        // "<init>":()V
  #50 = Class              #66            // java/lang/System
  #51 = NameAndType        #67:#68        // out:Ljava/io/PrintStream;
  #52 = Utf8               java/lang/StringBuilder
  #53 = Utf8               a + b =
  #54 = NameAndType        #69:#70        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #55 = NameAndType        #69:#71        // append:(J)Ljava/lang/StringBuilder;
  #56 = NameAndType        #72:#73        // toString:()Ljava/lang/String;
  #57 = Class              #74            // java/io/PrintStream
  #58 = NameAndType        #75:#76        // println:(Ljava/lang/String;)V
  #59 = Utf8               b / a =
  #60 = Utf8               b - a =
  #61 = Utf8               a * b =
  #62 = Utf8               ---this is split line---
  #63 = NameAndType        #75:#77        // println:(F)V
  #64 = Utf8               Hello
  #65 = Utf8               java/lang/Object
  #66 = Utf8               java/lang/System
  #67 = Utf8               out
  #68 = Utf8               Ljava/io/PrintStream;
  #69 = Utf8               append
  #70 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #71 = Utf8               (J)Ljava/lang/StringBuilder;
  #72 = Utf8               toString
  #73 = Utf8               ()Ljava/lang/String;
  #74 = Utf8               java/io/PrintStream
  #75 = Utf8               println
  #76 = Utf8               (Ljava/lang/String;)V
  #77 = Utf8               (F)V
{
  public Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 5: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LHello;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=6, locals=11, args_size=1
         0: ldc           #2                  // int 20000000
         2: istore_1
         3: ldc2_w        #3                  // long 300000000l
         6: lstore_2
         7: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
        10: new           #6                  // class java/lang/StringBuilder
        13: dup
        14: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
        17: ldc           #8                  // String a + b =
        19: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        22: iload_1
        23: i2l
        24: lload_2
        25: ladd
        26: invokevirtual #10                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        29: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        32: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        35: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
        38: new           #6                  // class java/lang/StringBuilder
        41: dup
        42: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
        45: ldc           #13                 // String b / a =
        47: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        50: lload_2
        51: iload_1
        52: i2l
        53: ldiv
        54: invokevirtual #10                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        57: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        60: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        63: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
        66: new           #6                  // class java/lang/StringBuilder
        69: dup
        70: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
        73: ldc           #14                 // String b - a =
        75: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        78: lload_2
        79: iload_1
        80: i2l
        81: lsub
        82: invokevirtual #10                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        85: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        88: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        91: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
        94: new           #6                  // class java/lang/StringBuilder
        97: dup
        98: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
       101: ldc           #15                 // String a * b =
       103: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
       106: iload_1
       107: i2l
       108: lload_2
       109: lmul
       110: invokevirtual #10                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
       113: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
       116: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       119: iconst_0
       120: istore        4
       122: sipush        200
       125: istore        5
       127: lload_2
       128: iload_1
       129: i2l
       130: lcmp
       131: ifle          139
       134: sipush        -300
       137: istore        5
       139: bipush        10
       141: newarray       float
       143: astore        6
       145: iconst_0
       146: istore        7
       148: iload         7
       150: bipush        10
       152: if_icmpge     168
       155: aload         6
       157: iload         7
       159: ldc           #16                 // float 0.01f
       161: fastore
       162: iinc          7, 1
       165: goto          148
       168: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
       171: ldc           #17                 // String ---this is split line---
       173: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       176: aload         6
       178: astore        7
       180: aload         7
       182: arraylength
       183: istore        8
       185: iconst_0
       186: istore        9
       188: iload         9
       190: iload         8
       192: if_icmpge     216
       195: aload         7
       197: iload         9
       199: faload
       200: fstore        10
       202: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
       205: fload         10
       207: invokevirtual #18                 // Method java/io/PrintStream.println:(F)V
       210: iinc          9, 1
       213: goto          188
       216: return
      LineNumberTable:
        line 7: 0
        line 8: 3
        line 11: 7
        line 12: 35
        line 13: 63
        line 14: 91
        line 16: 119
        line 18: 122
        line 19: 127
        line 20: 134
        line 23: 139
        line 24: 145
        line 25: 155
        line 24: 162
        line 28: 168
        line 30: 176
        line 31: 202
        line 30: 210
        line 33: 216
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
          148      20     7     i   I
          202       8    10     f   F
            0     217     0  args   [Ljava/lang/String;
            3     214     1     a   I
            7     210     2     b   J
          122      95     4     z   Z
          127      90     5     c   I
          145      72     6     d   [F
      StackMapTable: number_of_entries = 5
        frame_type = 255 /* full_frame */
          offset_delta = 139
          locals = [ class "[Ljava/lang/String;", int, long, int, int ]
          stack = []
        frame_type = 253 /* append */
          offset_delta = 8
          locals = [ class "[F", int ]
        frame_type = 250 /* chop */
          offset_delta = 19
        frame_type = 254 /* append */
          offset_delta = 19
          locals = [ class "[F", int, int ]
        frame_type = 248 /* chop */
          offset_delta = 27
}
SourceFile: "Hello.java"

```

> 常数加载指令表

|类型|常数指令|范围|
|---|---|---|
|int(boolean, byte, char, short)| iconst | [-1, 5] |
||bipush|[-128, 127] |
||sipush|[-32768, 32767]|
||ldc|any int value|
|long|lconst|0,1|
||ldc|any long value|
|float|fconst|0,1,2|
||ldc|any float |
|double| dconst| 0,1|
||ldc|any double value|
|reference|aconst|null|
||ldc|String literal,Class literal|

### 非静态的拼接逻辑在 JDK 8 中会自动被 javac 转换为 StringBuilder 操作

### 控制流指令，包括无条件跳转 goto，条件跳转指令，tableswitch 和 lookupswtich（前者针对密集的 cases，后者针对稀疏的 cases），返回指令，以及被废弃的 jsr，ret 指令。

### foreach 会计算数组的长度