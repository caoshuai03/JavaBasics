## Java进阶知识

### 匿名函数

```java
(参数列表) -> { 方法体 }
//排序
numbers.sort((a, b) -> a.compareTo(b));//升序，反过来就是降序
```

- 如果方法体只有一行代码，可以省略 `{}` 和 `return`。
- 如果参数只有一个，可以省略 `()`。





### 枚举

`enumeration`

枚举类是一种特殊的类，用于定义一组固定的常量。

1. **构造器是默认私有化**
2. 去掉Set方法，防止属性被修改
3. 枚举对象默认是`static fanal`

#### 创建枚举对象

1. 用`enum`关键字代替`class`
2. 直接形参名（参数列表）代替创建对象，对象之间用逗号间隔，结尾用分号，并且**必须写在最前面**

**注意**

1. `enum`类是一个`final`类，不能继承，但可以实现接口
2. 使用无参构造器，可以省略括号

```java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6), // 水星
    VENUS(4.869e+24, 6.0518e6),  // 金星
    EARTH(5.976e+24, 6.37814e6); // 地球

    private final double mass;   // 质量
    private final double radius; // 半径

    // 枚举类的构造方法
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    // 计算行星表面的重力加速度
    public double surfaceGravity() {
        double G = 6.67300E-11; // 万有引力常数
        return G * mass / (radius * radius);
    }
}
```



**常用方法**

1. **toString**：返回对象名，可以重写改方法
2. **name**：返回对象名（常量名）
3. **ordinal**：返回当前对象的位置号，从0开始
4. **values**：返回一个数组，里面是所有对象的toString返回
5. **valueOf**：根据输入的字符串进行查找对象，有就返回对象
6. **compareTo**：返回两个对象的编号相减



### 注解

做语法校验

### 异常处理

```
try{

}catch{

}
catch{

}finally{

}
```



1. 将捕捉到的异常传给`catch`，然后执行`catch`的内容，最后都会执行`finally`，用于释放资源
2. `throws`抛出异常，返回给调用者，`JVM`是顶级的处理者，默认类都有`throws`异常
3. `try`里面，异常出现后的代码不会执行
4. 可以有多个`catch`，子类异常必须在父类异常前面，因为如果父类在前面会把所有异常都捕获，就做不到捕获多个不同异常
5. 会出现`try-finally`，用于无论有没有异常都要执行`finally`模块
6. `finally`必定执行，即使遇到`return`在`try`里面也要执行



#### `throws` 异常类型

用于方法签名中，声明该方法可能会抛出的异常类型

1. 子类重写的方法，**抛出的异常类型必须小于等于**父类抛出的异常类型

2. **编译异常必须显示得处理**，运行异常不用必须显示处理
3. 后面跟的是异常类型

#### throw

用于在代码中显式抛出一个异常

1. 在方法体内使用，手动生成异常处理的关键字

2. 后面跟的是异常的对象


### 包装类

| 基本数据类型 | 包装类    |
| ------------ | --------- |
| boolean      | Bollean   |
| char         | Character |
| byte         | Byte      |
| short        | Short     |
| int          | Integer   |
| float        | Float     |
| long         | Long      |
| double       | Double    |

#### 自动装箱和自动拆箱

1. `valueOf` 基本数据类型到包装类，**用什么调用`valueOf`，就得到什么类**
2. `intValue` 包装类到基本数据类型

```java
int n1 = 10;
Integer integer1 = n1;
//自动装箱，底层用的Integer.valueOf(n1)
int n3 = integer1;
//自动拆箱，底层用的integer1.intValue()
```

三元运算符是一个整体，会赋值精度更高的那一个

```java
Object obj = true?new Integer(1):new Double(2.0);
System.out.println(obj);
```

### String

**数值转成字符串**

- `i.toString` 

- `String.valueOf(i)`

**字符串转成数值**

- `Integer.parseInt(String)`，**遇到`parse`就是处理字符串，将字符串转成包装类**

- 如果integer赋值的范围不在`-128~127`，就`new`一个

#### 内存布局

底层是用的字节数组`value`

直接赋值，是去看方法区有没有，没有就创建，然后存储方法区的地址；`new`一个`String`，是在堆空间开辟，有个字节数组`value`去方法区看有没有字符，然后存储的是堆空间的地址

![image-20250216220314317](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250216220314317.png)



```java
String str1 = "123" + "abc";
// 只创建了一个对象，会优化成String str1 = "123abc"

String str2 = a + b;
// 创建了一个对象，底层是先创建StringBuilder然后append，最后new一个返回给str2
```

常量相加，看的是池
变量相加，看的是堆

#### 常用方法

```java
String str1 = "jgjhfgsjscs";
String str2 = str1.substring(2,6);//左闭右开
System.out.println(str2);//jhfg
```

![image-20250216225241360](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250216225241360.png)

![image-20250222161244282](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222161244282.png)

`toCharArray()`: 将字符串转换为字符数组。

`valueOf(Object obj)`:  将基本数据类型转换为字符串。

`getBytes()`:字符串转成字节数组

`compareTo`：如何比较

1. **字典顺序**: 从字符串的第一个字符开始逐个比较字符的 `Unicode` 值。
2. **长度差异**: 如果两个字符串的前缀相同，但长度不同，较短的字符串被认为较小。
3. 返回值：负数（小于）表示调用者在前，正数（大于）表示调用者在后，`0`表示相等

### StringBuffer

1. 父类是`AbstractStringBuilder`

2. 父类中有`char[] value` 存放值，放在堆中

3. 是一个`final`类，不能被继承


#### 与String互相转换

`toString`方法

```java
// string->striingbuffer  用构造器或者append
String s = new String("abc");
StringBuffer stringBuffer = new StringBuffer(s);
StringBuffer stringBuffer1 = new StringBuffer();
stringBuffer1.append(s);

// striingbuffer->string  用toString方法或者构造器
StringBuffer stringBuffer = new StringBuffer("abc");
String s = stringBuffer.toString();
String s1 = new String(stringBuffer);
```

#### 增删改查

```java
StringBuffer sb = new StringBuffer("abc123");
// append 增，会返回一个sb类
sb.append("456"); //abc123456
// delete 删，左闭右开
sb.delete(3,6); //abc456
// replace 改
sb.replace(3,6,"123"); //abc123
// indexOf 查，查找子串第一次出现的索引
System.out.println(sb.indexOf("123")); //3
// insert 插，在索引位置【前面】插入
sb.insert(3,"efg"); //abcefg123
// length 长度
System.out.println(sb.length()); //9
```

#### 三者的区别

![image-20250222160703410](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222160703410.png)

#### 使用原则

![image-20250222161132552](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222161132552.png)



### Math

直接`Math.method`

![image-20250222162219736](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222162219736.png)



### Arrays

数组操作**相关方法**，很重要

![image-20250222164627203](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222164627203.png)



![image-20250222165717845](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222165717845.png)

`Arrays.asList()`	

### System



![image-20250222172828095](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222172828095.png)



### 超大数

#### BigInteger

**目的是存储很大的数，可能面试会问到**

是一个类,创建要`new`对象

`add subtract multiply divide`

加 减 乘 除 必须与`BigInteger`或者`long`类型的数操作

#### BigDecimal

需要保存一个精度很高的小数

使用方法同上

在进行除法`divide`的时候，可能会除不尽抛出异常，可以指定精度

### 获取时间

#### Date

获取当前时间，格式是国际格式，需要格式化

`SimpleDateFormat`

```java
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 kk:mm:ss");
String s = sdf.format(date);//2025年02月22日 22:07:19
//还可以将字符串转换成date
//s="2025年02月22日 22:07:19"
Date d1 = sdf.parse(s);
```

![image-20250222220351066](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222220351066.png)



#### Calender

![image-20250222222910467](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222222910467.png)



#### LocalDateTime

![image-20250222223729850](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222223729850.png)



用`DateTimeFormatter`进行格式化，相应格式类似于`SimpleDateFormat`

![image-20250222223835830](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222223835830.png)



#### Instant

时间戳

![image-20250222224238590](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250222224238590.png)



## 集合

也就是可以动态变化的数组

![image-20250223104412496](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223104412496.png)



### Collection



### List

1. 只要是object都可以添加
2. 元素是**有序的**，即添加顺序和取出顺序一致
3. 元素**可以重复**
4. 可以通过`get`索引取出元素，**`set`集合不能索引**

#### 初始化

```java
// 使用 ArrayList 初始化
List<String> arrayList = new ArrayList<>();

// 使用 Arrays.asList() 初始化
List<String> list = Arrays.asList("Apple", "Banana", "Cherry");


// 使用双括号初始化
List<String> list = new ArrayList<String>() {{
    add("Apple");
    add("Banana");
    add("Cherry");
}};
```

#### 常用方法



![image-20250223112605711](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223112605711.png)

![image-20250223121526143](C:/Users/Lenovo/AppData/Roaming/Typora/typora-user-images/image-20250223121526143.png)



| 方法             | 返回类型   | 是否需要指定数组类型 | 适用场景               |
| ---------------- | ---------- | -------------------- | ---------------------- |
| `toArray()`      | `Object[]` | 否                   | 不需要具体类型时使用。 |
| `toArray(T[] a)` | `T[]`      | 是                   | 需要具体类型时使用。   |

```java
list.toArray(new int[list.size()][]);//转成二维数组
```

第二个传入长度的时候

- 可以指定目标数组的类型（如 `String[]`、`Integer[]` 等）。
- **如果传入的数组长度足够，则直接使用该数组；否则，会创建一个新的数组**。

#### 遍历元素

```java
// 创建list
ArrayList list = new ArrayList();
list.add("jack");
list.add(999);
list.add(new Double(9.99));

//方法1
// 调用iterator方法，得到迭代器
Iterator it = list.iterator();
// 用itit快捷键，可以遍历集合list
while (it.hasNext()) {
    Object obj =  it.next();
    // 
}
//重置迭代器
it = list.iterator();

//方法2
//用增强for遍历元素
for(Object obj : list){
    ////
}
```

> 增强for底层还是迭代器，也可以在数组使用增强for

#### ArrayList底层结构

`transient`表示属性不会被序列化

![image-20250223151359685](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223151359685.png)

#### Vector

1. 如果需求线程同步，则用`Vector`，其中方法用`synchronized`修饰
2. 如果只是单线程，则用`ArrayList`

![image-20250223153247276](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223153247276.png)

#### LinkedList

1. **双向链表存储**，线程不安全
2. 如果改查比较多，用`ArrayList`（实际开发也是查询更多）
3. 如果**增删**比较多，用`LinkedList`

### Set

#### HashSet

**哈希集合**

1. **没有顺序**，即添加顺序和取出顺序不一致，但每次取出顺序是固定的
2. **元素不能重复**，只能有一个`NULL`
3. 底层原理是`HashMap`
4. 添加元素是先计算对应的哈希值，得到对应的索引位置，然后用**`equals`进行比较**，要不要添加
5. **删除元素也是先计算此元素的哈希值**，看对应位置有没有元素
6. **简单来说，哈希值决定数组位置，内容决定是否添加**

![image-20250223163240859](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223163240859.png)

**考点：集合不会动态修改位置**

```java
//考点：集合不会动态修改位置
HashSet hashSet = new HashSet();
//Person类的hashcode和equals方法跟id和name有关
Person aa = new Person(111, "AA");
Person bb = new Person(222, "BB");
hashSet.add(aa);
hashSet.add(bb);
//添加两个元素后，再修改aa的名字，但是集合里面不会动态修改位置
aa.setName("CC");
//此时删除aa，是按照原来的"AA"来计算hashcode，那么删除失败
hashSet.remove(aa);
//此时添加与aa一样的数据，但是位置会放在与aa不同位置，所以添加成功
//因为集合不会动态修改原来aa的位置
hashSet.add(new Person(111, "CC"));
System.out.println(hashSet);
```



#### 扩容机制

与`HashMap`大致相同

简单来说，**元素个数一但到临界值就会扩容两倍**，临界值是数组空间（初始16）乘以0.75；

同时**某一链表元素达到8个以上看情况**：此时如果数组个数没有超过64，会继续扩容；如果超过了64就会树化成红黑树

![image-20250223163410898](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223163410898.png)

> 如果认为名字和年龄相同就是同一个对象，即不存储到`HashSet`里面，需要重写`hasCode`和`equals`方法

```java
class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public boolean equals(Object object) {//控制比较情况，此时比较的是名字和年龄，相同则不存储
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dog dog = (Dog) object;
        return age == dog.age && Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {//控制是否存储到同一个数组
        return Objects.hash(name, age);
    }
    //...
}
```

#### TreeSet

`TreeSet` 的底层是基于红黑树（Red-Black Tree）实现的，而不是 `HashSet` 或双向链表。红黑树是一种自平衡的二叉搜索树，它保证了插入、删除和查找操作的时间复杂度为 O(log n)。`TreeSet` 中的元素是按照自然顺序（`Comparable`）或者自定义比较器（`Comparator`）进行排序的，因此遍历顺序也是有序的（默认是升序）。

`TreeSet` 通过红黑树的特性保证元素的唯一性。如果尝试插入一个已经存在的元素，`TreeSet` 会忽略该操作。`TreeSet` 不允许存储 `null` 元素，因为 `null` 无法参与排序。`TreeSet` 是非线程安全的，如果需要线程安全的实现，可以使用 `Collections.synchronizedSortedSet`。



### Map

#### HashMap

1. 键值对（`Key-Value`）存储
2. 键`key`不能重复，**如果遇到重复的就替换掉**
3. 值可以重复
4. **`key`和`value`可以为NULL**，并且`key`为`NULL`只能有一个（不能重复），`value`为`NULL`可以有多个
5. **常用字符串用做`key`**
6. **通过`key`可以找到对应的`value`**
7. 是线程不安全的
8. 扩容机制与HashSet相同，乘以2

![image-20250223174842463](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223174842463.png)

![image-20250223175413040](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250223175413040.png)

##### **遍历**

1. 用`keySet`得到键，然后`get`得到对应值（常用）
2. 用`entrySet`得到集合，用`for`增强后，再用方法`getKey`和`getValue`
3. 用`values`只能得到值

```java
//遍历用法

//返回键的set集合
Set<String> strings = map.keySet();
for (String string : strings) {
    System.out.println(string + map.get(string));
}

//返回值的Collection集合
Collection<Integer> values = map.values();
for (Integer value : values) {
    System.out.println(value);
}

//返回一个set集合，里面存储的是entry，通过entry可以得到对应的键值对
Set<Map.Entry<String, Integer>> entries = map.entrySet();
for (Map.Entry<String, Integer> entry : entries) {
    System.out.println(entry.getKey() + entry.getValue());
}
```

##### 扰动函数

如果直接用`hashCode`计算索引值，就只用到了低位信息，通过绕动函数，将低位高位混合起来，可以更好的缓解哈希冲突

```java
(h = key.hashCode()) ^ (h >>> 16);
```



### ConcurrentHashMap

实现了线程安全，并发执行

**数组+单向链表+红黑树**

（**存储形式和扩容与HashMap一样**）初始化16哈希表，哈希冲突时，采用的是链式存储，还有一个负载因子默认0.75，不能修改

**存储数据单元是Node结构**，key、value是volatile，next

对Node加锁，保证数据更新的安全性，锁的粒度是数组中的一个节点





#### HashTable

1. **键和值不能为空**，为空会抛出异常
2. 是线程安全的
3. 扩容机制为乘以2加1



#### Properties

用法与`HashTable`差不多，主要是用于**配置文件**

**写法**：键=值，不需要有空格，值不用引号括起来，默认是`String`

![image-20250226195516117](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250226195516117.png)

```java
//创建和写入配置信息
Properties properties = new Properties();
properties.setProperty("jack", "123");
properties.setProperty("user", "汤姆");
properties.setProperty("pass", "345");
//第二个参数是注释
properties.store(new FileOutputStream("e://mysql.properties"), null);

//获取配置信息
Properties properties1 = new Properties();
properties1.load(new FileReader(path));
String user = properties.getProperty("user");
System.out.println(user);
```

### 如何选择

![image-20250224141925994](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250224141925994.png)



### CollecTions工具

对集合处理的方法

![image-20250224143116404](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250224143116404.png)



![image-20250224143448026](https://gitee.com/caoshuai03/typora-images/raw/master/image-20250224143448026.png)

### 比较

```java
employees.sort(new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
    	//返回的是一个数，数的正负决定排序顺序
    	//return o1.getName().length() - o2.getName().length(); 
        //可以用compareTo方法
        return o1.getName().compareTo(o2.getName());
    }
});
```



## 泛型

```java
class Dog<E, T> {
    E e;
    //E[] es = new E(10);不能实例化
    E[] es;//可以定义
    //static E e1;静态方法（属性）不行
	
    //方法的返回类型是泛型
    public T f(T t) {
        return t;
    }
    //方法是泛型方法
    public<R> void f1(R r){
        //这里可以使用类标识的和方法标识的泛型E、T、R
    }
    
    //使用泛型
    public void f2(E e){
        //这里只能使用类标识的泛型E
    }
}
```

1. 个人理解：就是某个可能会有不同类型，就用泛型`<E,K,V>`暂代，使用的时候（编译期间）标明类型即可

2. 泛型可以标识**类、属性的类型、泛型方法、方法的返回类型或者参数类型**，泛型只能是**引用类型**
3. 泛型一般是任意大写字母，可以有多个泛型
4. 定义时，**不能实例化**泛型数组
5. 不能用`static`修饰泛型，因为`static`在类加载的时候出现
6. 给泛型指定类后，传入时可以**传入指定类及其子类**
7. 不指定泛型类型时，默认是`Object`
8. 泛型没有继承性
9. `?`表示任意泛型，`extends`表示及其子类，`super`表示及其父类（理解成小于等于和大于等于）

```java
//ArrayList<Object> objects = new ArrayList<String>();泛型没有继承性

//?表示任意泛型，extends表示及其子类，super表示及其父类（理解成小于等于和大于等于）
public void f(List<?> list){

}
public void f1(List<? extends Employee> list){

}
public void f2(List<? super Employee> list){

}
```



 









