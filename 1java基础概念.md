# Java 编程入门全知道：从基础概念到实践运行与开发要点

## 程序
程序：有序指令的集合。

## Java特点

- **面向对象（`OOP`）**：`Java`是面向对象的编程语言。
- **健壮性**：包括垃圾回收机制、异常处理。
- **解释性语言**：`Java`代码在运行时会被解释执行。
- **跨平台运行**：编译后的`.class`文件可以在不同平台上运行。
- 编译，一次性翻译成机器码，解释，一句一句解释成机器码
- `Java`即是编译型的，也是解释型语言，总的来说`Java`更接近解释型语言。
1. **java先编译成`.class`文件，字节码，然后在`JVM`上解释运行**

**`Java Development Kit` (`Java`开发工具包)**

包含了`JRE`和各种`Java`开发工具。

![image-20241124140705700](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241124140705700.png)

## JRE

**`Java Runtime Environment` (`Java`运行环境)**

如果只运行`Java`，使用`JRE`即可，在`jdk11`后已经跟`jdk`融合在一起了，不能单独下载

包含了`JVM`和`Java`核心类库。

## JVM

**`Java Virtual Machine` (`Java`虚拟机)**

包含在`JDK`中，通过`JVM`可以让`Java`在不同平台运行。



![image-20241124140956541](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241124140956541.png)

## 三者之间的关系



![image-20241124143153250](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241124143153250.png)

## HelloWord

```java
//java快速入门
//main是一个类 public类型的类
// {}表示开始和结束
public class Main{
    //表示主方法 程序的入口 main(){} main方法固定书写格式 
    public static void main(String[] args){
        //输出,分号;代表语句结束
        System.out.println("Hello world!!!");
    }
}
```

## 运行



![image-20241127135359358](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241127135359358.png)

## 流程分析



![未命名绘图.drawio](https://gitee.com/caoshuai03/typora-images/raw/master/%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE.drawio.png)

源文件（`.java`）—字节码文件（`.class`）——运行结果



![image-20241127140953083](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241127140953083.png)

- 编译后每一个类都对应一个`.class`
- 文件名应与`public`类名相同
- 一个文件只能有一个`public`类

## API

**Application Programming Interface**

**应用程序编程接口**

## 学习方法



![image-20241127142113244](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241127142113244.png)





![image-20241127143109110](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241127143109110.png)

1. windows `\n` =  MacOS的 `\r` 意思是回车并换行

2. 在Linux、unix 中  

   - `\n`只表示换行，但不会回到下一行的开始位置

   - `\r`表示回车，返回到当行的最开始位置



- 多行注释不能嵌套多行注释
- 在类和方法常用文档注释 `/**  */`


## 斜杠与反斜杠
### 斜杠（/）



更加常用，在计算机、运算等使用

**区分**

根据八字，先斜杠`/`，后反斜杠`\`

**用途：**

- **URL和网址路径：** 斜杠通常用于表示网页地址和文件路径中的分隔符。例如，在网址 `http://www.example.com/path/to/resource` 中，斜杠 `/` 用来分隔不同的路径部分。
- **数学运算：** 在某些编程语言中，斜杠 `/` 表示除法运算，如在Python中 `5 / 2` 表示5除以2。

**出现的地方：**

- 网页浏览器地址栏。
- 编程代码中表示文件路径。**代码中的文件路径**
- 数学表达式中表示除法。

### 反斜杠（\）

更加原始自然的，没那么常用

**用途：**

- **文件系统路径：** 在Windows操作系统中，反斜杠 `\` 被用作文件路径的分隔符。例如，`C:\Users\Username\Documents`。
- **转义字符：** `\n,\r,\b`等等之类的**转义字符用反斜杠**
- **DOS命令提示符：** 在早期的DOS系统中，反斜杠被用作命令提示符的一部分。

**出现的地方：**

- Windows文件资源管理器中的文件路径。**文件管理器复制的路径**
- 编程代码中，特别是在字符串中作为转义字符。
- 早期的DOS命令行。

# Java基础全解析：变量、数据类型、运算符与控制流程

## Java变量

变量类似于指针，修改变量值，对应的值也会修改



![image-20241205153842963](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241205153842963.png)

但是传递变量，只是**值拷贝**

```java
int n1=10;
int n2=n1;
n2=20;
System.out.println(n1);//结果是10，因为这是值拷贝，但是数组就是引用传递，会修改对应数值
```

## 变量三要素

变量=变量名+值+数据类型



## Java数据类型

| 数据类型 | 字节数 | 备注                                   | 范围           |
| :------- | :----- | :------------------------------------- | -------------- |
| byte     | 1      | 字节                                   |                |
| short    | 2      | 短整型                                 |                |
| int      | 4      | 整型（整数常量默认为int）**常用**      | -2^31 ~ 2^31-1 |
| long     | 8      | 长整型                                 | -2^63 ~ 2^63-1 |
| float    | 4      | 单精度                                 |                |
| double   | 8      | 双精度（浮点常量默认为double）**常用** |                |
| char     | 2      | 单个字符`'a'`                          | 0~2^16-1       |
| boolean  | 1      | 布尔 小写的`true`和`false`             |                |

1. Java 里使用 `long` 类型的数据一定要在数值后面加上 **L**，否则将作为整型解析。
2. Java 里使用 `float` 类型的数据一定要在数值后面加上 **f 或 F**，否则将无法通过编译。
3. `char a = 'h'`char :单引号，`String a = "hello"` :双引号。
4. 这八种基本类型都有对应的包装类分别为：`Byte`、`Short`、`Integer`、`Long`、`Float`、`Double`、`Character`、`Boolean` 。
5. 基本数据类型如果是局部变量，那么它们会存放在栈中；如果它们是成员变量，那么它们会存放在堆/方法区/元空间中。

```java
public class Test {
    // 成员变量，存放在堆中
    int a = 10;
    // 被 static 修饰的成员变量，JDK 1.7 及之前位于方法区，1.8 后存放于元空间，均不存放于堆中。
    // 变量属于类，不属于对象。
    static int b = 20;

    public void method() {
        // 局部变量，存放在栈中
        int c = 30;
        static int d = 40; // 编译错误，不能在非静态方法中使用 static 修饰局部变量
    }
}
```


![image-20241128165445287](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241128165445287.png)

### 引用类型

- 类 `class`（包括`String`）
- 接口 `interface`
- 数组 `[]`



1 `byte` = 8 `bit`

1字节等于8比特



**浮点数=符号位+指数位+尾数位**

比如说`123.567`表示为`+1.23567e2`

尾数位可能丢失，造成精度损失，可以说小数都是近似值



```java
float n1 = 1.1; //错误 因为浮点常量（具体值）为double
float n2 = 1.1f; //正确
double n3 = 1.1; //正确
```

计算得到的小数比较，要作差

```java
		double x1 = 2.7;
        double x2 = 8.1 / 3;
        //计算得到的小数比较，要作差
        if (x1 == x2) {
            System.out.println("==equal");
        }
		//计算得到的小数比较，要作差
        if (Math.abs(x1 - x2) < 1e-6) {
            System.out.println("< equal");
        }
        System.out.println(x2);
		//        输出结果
		//        < equal
		//        2.6999999999999997
```

1. `char`的本质是一个整数，输出`unicode`码对应的字符
2. `char`字符运算时，是对应的`ascll`数字运算，而字符串`String`运算时是字符相加

```java
System.out.println('a' + 10);//107
System.out.println("a" + 10);//a10
```



- `ASCLL`编码表有128个字符，用一个字节表示（实际上可以表示256个字符但只用了128），主要用于英文文本，无汉字
- `Unicode`字符集，用两个字节表示，字母和汉字都是两个字节，缺点是占用内存
- `utf-8(8-bit Unicode Transformation Format)`编码表，字母用一个字节，汉字用三个字节，兼容`ASCLL`，是`unicode`的一种表现形式
- `GBK`编码表，字母用一个字节，汉字用两个字节，支持更多汉字



布尔类型不能用0或非0代替，只能是`true or false`



## 自动类型转换

小转大，大不能赋值给小

`byte`比较特殊，只要数值在范围内就可以赋值（`char`一样）

```java
byte b = 100;//可以
```

`（byte，short）`和`char`之间不会相互转换

整数运算时会把精度提升为`int`

![image-20241128195942253](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241128195942253.png)



### 基本类型转换

`Integer.parseInt`将`String`类型转换为`int`

`n+""`就可以简单将其他数值转换为`String`，或者通过`String.valueOf()`



## 自增

**注意，与c++不一样**

```java
int i = 1;
i = i++;
System.out.println(i);
//输出1

int i = 1;
i = ++i;
System.out.println(i);
//输出2
```

这是因为 `JVM` 在处理 `i= i++;`时,会建立一个**临时变量**来接收`i++` 的值,然后返回这个临时变量的值

相当于`temp=i++（1）` ， `i++`运算后， `i=temp`

## 逻辑运算符

- `&&`短路与，当第一个为假，后面不在执行，**开发中常用这个效率更高**
- `&`逻辑与，当第一个为假，后面继续执行
- `||`短路或也是常用的，第一个为真时，后面不在执行
- `^`异或，相同时为假，**不同时为真**

## 赋值运算符

```java
byte b1 = 1, b2 = 1, b3 = 1;
b1 += 1;//正确
b2++;//正确
b3 = b3 + 1;//错误，转换成int类型
```

**使用`+=`或者++时，会自动强制类型转换**

## 标识符命名规范

类名、接口名，所有单词首字母大写`XxxYyy`大驼峰

变量名、方法名，从第二个单词首字母大写 `xxxYyyZzz`小驼峰

常量名，所有字母大写 `MAXNUM`

## 键盘输入

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myScanner=new Scanner(System.in);
        //如果是next就输入一个字符串
        int age=myScanner.nextInt();
        System.out.println(age);
    }
}
```

## 进制转换

二进制转八进制，每三位数字一组，对应的0-7：10101010  ->    152

二进制转十六进制，每四位数字一组，对应的0-F



## 原码、反码、补码

- 二进制**最高位是符号位**，0表示正数，**1表示负数**（1旋转90度就是负号）
- **正数**的原码、反码、补码相同（三码合一）
- 负数的反码：它的**原码符号位不变**，其他位取反（0变1,1变0）
- 负数的补码：它的反码+1
- **计算机运算时，都是以补码的方式运算**，计算机只有加法，任何一个负数都可以找到一个对应的正数，因为都在一个周期里面，所以出现了补码
- 运算出来的结果，要转换成**原码**查看
- `java`的数都是有符号的数
- 0的反码、补码都是0

- 右移>>相当于除以2
- 左移<<相当于乘以2

## switch

```java
swtich(表达式){
    case 常量 :
    	xxx;
    	break;
    case xx :
    	xxx;
    	break;
	...
        
    default:
    	xxx;

}
```

- 表达式的数据类型应该和后面的常量类型一致
- 表达式的类型应该是`（byte、short、int、char、String、enum[枚举]）`**浮点数double不行**
- `case`后面的必须是常量或常量表达式
- `default`可选

可以使用**穿透**

![image-20241205161847382](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241205161847382.png)

## for循环

化繁为简：先从简单的开始操作

先死后活：先用常量跑通，再把常量再变成变量



## while

`do..while`一定会执行一次

```java
do{
	xx;
    i++;
}while(循环条件);//最后有一个分号

while(){
    
    
}
```

## 数组

### 初始化

```
//静态初始化
double[] abc={x,y,z};

//动态初始化1，这个动态指的不是空间大小可动
double[] scores = new double[5];
//动态初始化2
double[] scores;//先声明
scores = new double[5];//再分配空间
//第三种初始化
int[] ints=new int[]{1,2,3};
```

`boolean`数组初始化默认为`false`

### 访问数据

`a[i]`得到第`i`个数值，范围是`0-array.length-1` 

`array.length` 数组长度，**这是一个属性**

### 二维数组

![image-20241205184344994](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241205184344994.png)









