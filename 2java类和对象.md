# Java核心特性解析：静态成员、单例模式、抽象方法与接口

## 静态成员

**调用静态成员时看编译类型**

1. **静态成员通常用类.来访问，但不能访问非静态成员**，也可以用对象调用，但很少这样
2. **静态方法中只能调用静态相关的（属性、方法、代码块），非静态可以调用全部的**
3. 静态成员是所有对象**共享的**，**是属于类本身的**

4. **用类直接调用，不用创建对象**

```java
public class test01 {
    public static void main(String[] args) {
        C c = new D();//看左边编译类型为C
        System.out.println(c.name);//调用静态变量看编译类型
    }
}

class C {
    static String name = "jack";
}

class D extends C {
    static String name = "merry";
}
```

### 类变量

静态变量，`static`修饰

1. **所有对象共享的变量**
2. 在类加载的时候出现
3. 一般不会在构造器初始化，一般在定义的时候直接初始化

```java
public static int count = 0;
```

### 类方法

静态方法

**使用条件**

在多态中，**调用静态方法看编译类型，而调用普通方法看运行类型**

```java
public class test01 {
    public static void main(String[] args) {
        A a = new B();
        a.hi();
        a.hello();
    }
}
class A {
    public static void hi() {
        System.out.println("A的静态方法");
    }
    public void hello() {
        System.out.println("A的普通方法");
    }
}

class B extends A {
    public static void hi() {
        System.out.println("B的静态方法");
    }
    public void hello() {
        System.out.println("B的普通方法");
    }
}
```

1. 不创建实例来调用某个方法，相当于**当做工具来使用**，可以写成静态方法

2. **静态方法中不能使用**`this`、**`super`**关键字，因为这两个关键字跟实例相关
3. **静态方法只能访问静态成员**（属性和方法）
4. **普通方法可以访问所有成员**
5. 静态方法可以重载，**静态方法没有重写**

`super` 是基于实例的，因为它依赖于当前对象的实例上下文。具体来说：

- 当你创建一个子类的对象时，这个对象不仅包含子类的成员，还包含父类的成员。
- `super` 的作用就是告诉程序：“去父类中找这个成员，但操作的是当前对象的实例。”


## main

```java
public static void main(String[] args){}
```

1. main方法是java虚拟机调用
2. 需要调用类的main方法，所以**必须是public**
3. 调用时**不用创建对象**，所以**必须是static**，同时**遵守静态方法的规则**
4. **可以接受String类型的数组参数**，java 执行程序 参数1 参数2...

## 代码块

可以理解成**只有方法体**的方法，代码块的调用优先于构造器

### 类的加载

1. 创建对象实例时
2. 创建子类实例，父类先加载，子类再加载
3. **使用类的静态成员时，也会去加载类以及父类**

### static代码块

1. **随着类的加载而执行，只会执行一次**
2. 在静态代码块里只能调用静态成员

### 普通代码块

1. **只有创建对象的时候执行**
2. 可以调用所有成员


### 调用顺序

1. 优先静态代码块和静态属性初始化，按定义顺序执行，**只会执行一次**
2. 其次普通代码块和普通属性初始化，按定义顺序执行，**只有创建对象的时候执行**
3. 最后是构造器

>  1 是在类加载中执行，2相当于在构造器中**隐藏了两句**，普通代码块、属性和构造器在一块执行

```java
public A() {
    //super();
    //调用普通代码块和初始化普通属性
    System.out.println("构造器");
}
```

**综合来说，根据1，从父类执行到子类，然后2-3在一起执行，从父类执行到子类**



## 模式集合

### 单例模式

某个类只能存在一个实例对象，并且只提供一个获得该对象的方法

单利模式**个人理解：**先**构造器私有化**，然后创建**一个静态私有的对象**，根据两种方式看**是否开辟空间**，最后**提供一个静态私有的方法返回该对象**

#### 饿汉式

通过这种方法，在类加载的时候就会创建这个对象，因此叫饿汉式

1. 将**构造器私有化**
2. 在类的内部创建对象，并且是静态对象和私有
3. 提供一个方法可以返回对象，并且是**静态方法和私有**，因此就可以用类直接得到一个唯一的对象
4. `RunTime`是经典的饿汉式单例模式
5. 可能存在资源浪费问题



```java
class GirlFriend {
    private String name;

    private static GirlFriend girlFriend = new GirlFriend("marry");

    //私有是禁止访问，static是用类直接调用方法可以得到对象
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return girlFriend;
    }

}
```



####  懒汉式

先声明，需要的时候再创建

1. 将**构造器私有化**
2. 在类的内部**先声明对象**，并且是静态对象和私有
3. 后续需要的时候判断是否为空，为空就开辟空间
4. 提供一个方法可以返回对象，并且是**静态方法和私有**，因此就可以用类直接得到一个唯一的对象
5. 缺点是多线程的时候可能会破坏单例



```java
class BoyFriend {
    private String name;
    private static BoyFriend boyFriend;//先声明

    public static BoyFriend getInstance() {
        if (boyFriend == null) {//第一次为空就开辟空间
            boyFriend = new BoyFriend("小帅");
            return boyFriend;
        }
        return boyFriend;
    }

    private BoyFriend(String name) {
        this.name = name;
    }
}
```



#### **双重检查锁**

**特点**: 在懒汉式的基础上，通过双重检查减少同步锁的开销，既保证线程安全，又提高性能

```java
public class Singleton {
    // 使用 volatile 保证可见性和有序性
    private static volatile Singleton instance;

    // 私有构造方法，防止外部实例化
    private Singleton() {}

    // 提供全局访问点
    public static Singleton getInstance() {
        if (instance == null) { // 第一次检查
            synchronized (Singleton.class) { // 加锁
                if (instance == null) { // 第二次检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

##### `volatile` 关键字

`volatile` 是 Java 中的一个关键字，用于修饰变量。它的主要作用是确保变量的**可见性**和**有序性**，但不保证原子性。

### 工厂模式

介绍: 先定义一个接口，用不同类来实现这个接口，再定义一个方法，输入一个参数与某一个类对应，返回这个类的对象

使用场景: 当需要根据条件**创建不同对象**时使用。

```java
public class Factory {
    public static void main(String[] args) {
        shape dog = getInstance("dog");
        dog.eat();
    }

    public static shape getInstance(String shape) {
        if (shape == null) return null;
        if (shape.equalsIgnoreCase("Dog")) return new Dog();
        if (shape.equalsIgnoreCase("Cat")) return new Cat();
        return null;
    }


}


interface shape {
    void eat();
}

class Dog implements shape {

    @Override
    public void eat() {
        System.out.println("狗在吃东西");
    }
}

class Cat implements shape {

    @Override
    public void eat() {
        System.out.println("猫在吃东西");
    }
}
```

### 模版模式

1. 先定义一个抽象类
2. 抽象类有一个抽象方法和普通方法，普通方法会调用这个抽象方法进行一些操作
3. 子类继承抽象类，重写抽象方法
4. 子类对象就可以调用普通方法完成对不同抽象方法的操作

```java
abstract class A {
    public abstract void job();

    public void calTime() {
        double start = System.currentTimeMillis();
        job();
        double end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}

class B extends A {
    @Override
    public void job() {
        for (int i = 0; i < 100000; i++) {
            System.out.print("");
        }
    }
}
```

## final

用`final`修饰

1. 不希望类被继承
2. 不希望方法被重载、重写
3. 不希望属性被修改
4. 不希望局部变量被修改

**重点：属性和方法不能修改**，但可以使用

**注意**

- `final`修饰属性后，属性是**常量**，格式类似`MAX_NUM`
- `final`修饰属性后，**属性初始化必须要赋值**，可以直接赋值、构造器赋值和代码块赋值
- `final`修饰属性后，如果是静态的属性，要么直接赋值，要么在静态代码块中赋值，不能在构造器中赋值，因为类加载时就会初始化静态属性，而构造器是创建对象才会使用
- `final`修饰方法后，**子类可以使用其方法**，只是方法不能被重载和重写
- 不能修饰构造器
- `final`往往和`static`一起使用，底层编译器做了优化，这样访问该属性时，不会加载类，会提高效率，可以当做一个常量来使用
- 包装类（`Integer`,`Double`,`Float`,`Boolean`）和`String`都是`final`类

```java
public class test01 {
    public static void main(String[] args) {
        System.out.println(C.name);//调用静态属性，会加载类，所以会优先执行static代码块
        System.out.println(C.CONST_NUM);//调用static final属性，不会加载类，所以没有执行static代码块
    }
}
class C {
    static String name="jack";
    static final int CONST_NUM=10;
    static {
        System.out.println("静态代码块");
    }
}
//静态代码块
//jack
//10
```

## 抽象类

`abstract`关键字

1. 抽象类的意义是在于设计，子类继承后对其抽象方法进行重写
2. `abstract`只能修饰类和方法
3. **有抽象方法的肯定是抽象类，有抽象类的不一定有抽象方法**
4. **抽象方法在子类必须重写**，否则子类也是抽象类
5. 抽象类**不能创建对象**
6. 抽象方法**不能加方法体`{}`**
7. **抽象方法不能使用`private`、`final`、`static`，因为这些都与重写违背**
8. 抽象方法可以用`public、protected、默认`修饰

## 接口

interface 接口

- 可以理解成一个**规范**

**注意**

1. **实现接口的类必须实现里面所有的方法**
2. 接口里是抽象方法，也可以写**default修饰的普通方法，和静态方法**
3. 接口里的所有方法都默认是`abstract public`，所以可以省略`abstract`和`public`
4. 接口里的所有属性都默认是`public static final`，**接口里的属性：**可以访问、接口直接访问、不能修改、是一个常量
5. **一个类可以实现多个接口，但只能继承一个类**
6. 接口不能继承类，但是可以**继承多个接口**
7. 接口的访问修饰符跟类一样，`public`和默认
8. 接口不能创建对象
9. 抽象类实现接口，可以不实现接口的方法

```java
interface face1 extends face2,face3,face4{
    int a=0;//默认public static final，相当于默认是一个常量
    void m1();//默认是abstract public
    default void m2(){
        System.out.println("普通方法");
    }
    static void m3(){
        System.out.println("静态方法");
    }
}
class A implements face1,face2,face3{}//可以理解成类A继承了接口1、2、3，所以接口1、2、3可以指向类A
```

### 多态性

1. 实现接口的所有类，都可以通过接口来指向这些类，可以把**接口理解成父类，实现理解成继承**
2. 多态的特性都可以用在接口上


### 多态传递

接口之间继承后，实现其子接口的类，可以用父接口去引用该类对象，看不懂直接上代码

```java
public class test01 {
    public static void main(String[] args) {
        inA ina = new C();
        //C类没有直接实现inA，但是inA是inB的父接口，所以可以用其多态性质，即向上传递
    }
}

interface inA{}
interface inB extends inA{}
class C implements inB{}
```



# Java编程基础：类、属性、方法、重载、继承与多态详解

## 类

```java
public class Dog {
    String breed;
    int size;
    String colour;
    int age;

    void eat() {
    }

    void run() {
    }

    void sleep(){
    }

    void name(){
    }
}
```

1. 同一个文件只能有一个`public`类，**并且`public`类名必须与文件名相同**
2. 类的访问修饰符只能有`public`或者默认
3. 一般把`main`方法写在`public`类里面


### 属性

- 访问修饰符 `public protected private 默认`
- 不赋值就是默认值，而**局部变量不赋值没有默认值**
- 用点`.`访问属性和方法

### 方法

```java
访问修饰符 返回数据类型 方法名(形参列表){
	语句;
	return xx;
}
public int m1(int a){
    return a + 1;
}
```

1. 一个方法最多一个返回值，可以用数组返回多个数值

2. 返回类型可以是基本类型和引用类型，必须和`return`一致或者可兼容

3. 调用时，参数传入类型也要一致或者可兼容，个数和位置也要对应

4. 传参数时，可以传入`Object`数组，其内容必须与形参列表保持一致


### 调用细节

同一个类中的方法，可以直接调用

![image-20241207135918846](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241207135918846.png)

不同类的方法，要先创建对象再调用，跨类调用方法还要和访问修饰符有关

## 重载

**OverLoad**

发生在**同一个类中**，可以存在多个**同名的方法**，但**形参列表必须不一致**

**注意**

1. **方法名**必须相同
2. 要求**形参类型不同**或者**个数不同**或者**顺序不同**，统一叫形参列表不同
3. 与形参的**取名无关**
4. 与**返回类型无关**
5. 与**访问修饰符无关**
6. 二有三无：方法名和参数列表有关；参数取名、返回类型和访问修饰符无关

```java
public int m1(int a){
    return a + 1;
}
```

## 可变参数

将**同一个类**中**多个同名**的并且**功能基本相同**，但是**参数个数不同**的方法封装成一个方法

```java
public int func(int... nums){
}
```

**注意**

1. 使用时，可以将可变参数看成数组，它的本质就是**数组**
2. 使用时，可以跟普通类型参数一起用，但**可变参数必须在最后**
3. 使用时，一个方法只能出现**一个可变参数**
4. 调用时，可以传入**0-无穷个**参数
5. 调用用，可以**直接传入数组**

## 作用域

**属性**：成员变量、全局变量，**可以不赋值使用**

**局部变量**：**除了属性的其他变量**，一般在方法中定义，或者代码块中也属于局部变量，**必须赋值使用**

**作用域**：属性的作用域为**整个类体**；局部变量的作用域在对应的**代码块中**`{}`



**注意**

1. 属性=成员变量=全局变量（叫法不同）
2. **局部变量和属性可以重名**，并且遵循**就近原则**访问
3. 在同一个作用域中，**局部变量不能重名**
4. 属性随着对象的创建而创建，销毁而销毁
5. 对象和属性存在于**堆内存**，局部变量则存在于**栈内存**。
6. 局部变量随着代码块创建和销毁，也就是在一次方法调用中
7. 属性可以在本类中使用，也可以在其他类使用；局部变量只能在作用域里使用
8. 属性可以添加修饰符；**局部变量不能添加修饰符**
9. 两个都可以用`final`修饰，修饰后就是常量

## 构造器

```java
//修饰符 方法名（类名）(形参列表){}
public Person(int age, String name){
    xxx;
}
```

1. 修饰符可以默认

2. **构造器不能写返回类型**

3. **方法名必须和类名相同**

4. 系统去完成调用，意义是在**创建对象后**的**对象初始化**


### 构造器重载

可以重载构造器，如果重载了就会覆盖原来默认的无参构造器，那么无参构造器就没有了，此时一般要加上无参构造器

### this关键字

1. 解决了构造器中形参名可以不能和属性名相同的问题，用`this`可以区分属性和形参

2. 哪个对象调用，`this`就代表哪个对象
3. 只能在类里面使用

#### this构造器

访问构造器语法：`this`(参数列表)

- 只能在构造器中使用
- 必须放在第一句

```java
class S{
    int age;
    String name;
    public S(){
        this(12,"ui");//在构造器中使用,必须是第一句
        System.out.println("使用构造器");
    }
    public S(int age,String name){
        this.age=age;
        this.name=name;
    }
}
```

## 访问修饰符



| 访问级别 | 访问控制修饰符 | 同类 | 同包 | 不同包的子类 | 不同包的非子类 | 访问总结                                       |
| -------- | -------------- | ---- | ---- | ------------ | -------------- | ---------------------------------------------- |
| 公开     | `public`       | √    | √    | √            | √              | 全部包的任何类                                 |
| 受保护   | `protected`    | √    | √    | √            | ×              | 本包任何类以及实现该类的子类，**让子类可访问** |
| 默认     | 没有修饰符     | √    | √    | ×            | ×              | 本包任何类，**在本包可访问**                   |
| 私有     | `private`      | √    | ×    | ×            | ×              | 本类                                           |

**访问规则**

看访问总结

**注意**

1. 修饰符可以修饰类、属性和方法
2. 只有默认和public可以修饰类

## 封装

**encapsulation**

- 把对象属性保护在内部，只有通过调用方法去操作属性
- 属性私有化
- 提供一个公共的set和get方法，一般这个方法写在父类上，在子类就不用重复写
- 使用构造器时，调用set方法


```java
class Encapsul{
    private int age;
    private String name;
    private double banlance;

    public Encapsul() {
    }

    public Encapsul(int age, String name, double banlance) {
        this.setAge(age);
        this.setBanlance(banlance);
        this.setName(name);
    }
	//get和set成对出现
    //get要有返回类型
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //判断和校验
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }
}
```

## 继承

`extends`关键字

继承解决代码复用性

代码的扩展性和维护性变好了

**注意**

1. `super()`必须在第一行，只能在构造器中使用，与`this`不能同时存在，**如果没有写会自动添加`super()`**
2. 使用子类构造器时，**总会优先调用父类的无参构造器**，**并且会一层一层往上从最高层开始调用**
3. **如果父类没有无参构造器**（一个类可以不写无参构造器，此时必定有其他构造器），**则必须手动添加`super`指定使用父类的其他构造器**
4. 所有类都是`Object`的子类
5. 子类只能继承一个父类（单继承）
6. 必须满足`is-a`的关系，即猫是一个动物
7. **访问属性或方法时**，**先访问子类**，如果**没有**就往上找父类的属性（理解成**就近原则**），如果直接遇到不能访问的，就直接报错，相当于被堵住了

### super

可以访问父类的属性和方法，但是**私有的不能访问**

**如果子类没有重名的**，那么下面三个方法都可以，是等价的

```java
method();
this.method();
super.method();
```

**如果有重名的**，那么`super`就是访问父类的属性和方法，`this`就是访问本类的属性和方法



## 重写

**Override**

发生在子类与父类中

**注意**

1. 重写时，子类的方法的**参数列表、方法名**，要和父类的**完全一致**，如果不一致就是新方法，就不属于重写
2. 重写时，子类方法的返回类型和**父类的返回类型一致**，或者是**父类返回类型的子类**，其他不同的返回类型都不行
3. 重写时，子类方法的**访问权限要大于等于**父类的
4. 对比重载，方法名相同，参数列表不同，返回类型无关，访问修饰符无关
5. 如果父类方法访问修饰符为 `private/final/static` 则子类就不能重写该方法，但是被 `static` 修饰的方法能够被再次声明。
6. **方法名和参数列表必须一致，返回类型小于等于，访问修饰符大于等于**

```java
class C{
    protected void m1(String str,int... nums){
        System.out.println("C的方法");
    }

}
class D extends C{
    @Override
    protected void m1(String str, int... nums) {//方法名和参数列表必须一致，返回类型和访问权限最好一致
        System.out.println("D的方法");
    }
}
```

## 多态

**能调用哪些方法看编译类型，运行的哪个方法看运行类型**；属性的值看**编译类型** 

**初步理解**

1. 一个对象的编译类型和运行类型可以不一致
2. **编译看左边，运行看右边**
3. 编译类型在定义对象时就确定了，不能变化；而运行类型可以变化
4. 一般是父类指向子类，或者调用方法时，子类传给父类，总而言之，需要**父类来接受子类**，因为子类有更多的功能
5. **在运行时，就看运行类型**
6. `getClass()`获取对象的运行类型，并且还可以获得`Class`对象

### 方法

调用方法看**运行类型**，动态绑定机制

**向上转型**（转向父类）

```java
//父类 引用名=new 子类() 向上转型
Student student= new Graduate();
//Student是Graduate的父类
```

- 向上转型**可以调用父类的成员**，但**不能调用子类特有的成员**，即对应重写的方法，能调用哪些由编译类型决定
- **能调用哪些方法看编译类型，运行的哪个方法看运行类型** 
- **向上转型后，优先调用运行类型**，但得调用非特有成员，即调用时的动态绑定机制

**向下转型**（需要调用子类的**特有成员**，就向下转型）

```java
Student student1=new Graduate();//父类引用
Student student2= new Student();//父类对象

//子类 引用名=(子类) 父类引用 向下转型
Graduate graduate=(Graduate) student1;
//Graduate graduate=(Graduate) student2;不行
//只能强转父类的引用，不能强转父类的对象
```

- 只能**强转父类的引用**，不能强转父类的对象
- 向下转型后，可以调用子类的所有成员
- 父类引用指向的对象必须与强转后的对象**一致**

### 一个例子看懂

```java
public class test01 {
    public static void main(String[] args) {
        C c = new D();//向上转型
        c.m1();//可以调用非特有方法，运行的是D的m1方法    
        System.out.println(c.name);//属性调用看编译类型
        if (c instanceof D){//判断c指向的对象是否是D（或其子类）
            System.out.println(((D) c).name);//向下转型
        }
    }
}

class C {
    public String name = "jack";
    protected void m1() {
        System.out.println("C的方法");
    }
}

class D extends C {
    public String name = "merry";
    @Override
    protected void m1() {
        System.out.println("D的方法");
    }
}
//D的方法
//jack
//merry
```

### 属性

属性的值看**编译类型**，没有动态绑定机制，**哪里声明哪里使用**

### instanceOf

用于判断对象的**运行类型**是否是某类或其子类

## Object

### 判断相等

#### ==

只有在基本类型才判断值，其他地方都判断地址是否相同

比较基本数据类型和包装类

比较基本数据类型和包装类时，会将包装类自动拆箱，然后比较值，因为比较基本数据类型效率更高

```java
int a=1;
Integer b=1;
System.out.println(a==b);// 输出 true
```

#### equals

1. `object`中判断地址
2. 其他类通常重写成判断值，例如`String`

**大部分时候就理解成，等号比较地址，equals比较值**

在自己创建的类中，如果没有改写equals，那么比较的就是地址

![image-20241209134005746](https://gitee.com/caoshuai03/typora-images/raw/master/image-20241209134005746.png)

### hashCode

返回哈希值

1. 同一个对象，哈希值肯定一样；不同对象，哈希值一般不一样

2. 哈希值根据地址计算得到

3. 后续可能会重写


### toString

1. 返回  包.类名+@+哈希值的16进制`com.sina.crm.static_.D@5594a1b5`

2. 子类也会重写toString，用于增加返回对象的属性信息

3. 直接输出一个对象，会自动调用toString方法


### finalize

垃圾回收，**应付面试**，工作中基本上不会用

若一个对象没有任何引用，此时系统就会销毁对象，**在销毁对象之前就会调用finalize，我们可以重写这个方法做一些释放资源的操作**

还可以用`System.gc`主动触发垃圾回收



## 内部类

**类的五大成员**

属性、方法、构造器、代码块、内部类



### 局部内部类

当内部类单独出现没有什么意义，又是一个独立的个体，此时需要用到内部类

1. 定义在外部类的方法中或者代码块中
2. 作用域在对应代码块中
3. 仍然是一个类，对应的类的使用方法
4. 局部类可以直接调用**外部类的所有成员**，使用局部类则需创建对象
5. 局部类访问外部类的属性，如果重名了，根据就近原则，可以用**外部类名.this.属性名**进行访问
6. 可以理解成局部变量

### 匿名内部类

**Anonymous**

```java
new Inner() {};//必须有分号，可以理解成创建对象，跟创建对象比多了一个大括号的内容
```

1. 需求：**类只使用一次，后续不再使用**
2. 编译类型就是接受的左边类型，运行类型就是匿名类，底层匿名类名是**外部类名&1**
3. 可以访问**外部类的所有成员**
4. 如果重名，可以用**外部类名.this.属性名**进行访问外部类
5. 用匿名内部类创建出来就是一个对象，即可以访问方法，可以当作参数传入
6. 对接口就是实现，对类就是继承，左边就是父类对其接受
7. `new`出来就是一个对象，用父类指向这个对象，就可以后续使用这个对象，所以可以理解成创建对象并赋值，所以可以写在定义属性的位置



```java
public class test01 {
    public static void main(String[] args) {
        new AA() {
        }.m1();//匿名创建一个对象，调用m1方法

        new AA() {
        }.m2(new AA() {
        });//先创建一个对象调用m2方法，然后再创建一个对象当作参数传入
    }

}


class AA {
    public void m1() {
        System.out.println("m1方法");
    }

    public void m2(AA aa) {
        System.out.println("m2方法");
    }
}
//m1方法
//m2方法
```















