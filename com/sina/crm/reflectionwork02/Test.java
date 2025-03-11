package com.sina.crm.reflectionwork02;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /**
        //读取文件
        Properties properties = new Properties();
        String path = "src/prop.properties";
        properties.load(new InputStreamReader(new FileInputStream(path)));

        //读取配置文件信息
        String className = (String) properties.get("class");
        String methodName = (String) properties.get("method");

        //获取字节码文件
        Class clazz = Class.forName(className);
        //获取对应方法
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);

        //获取属性名，后面初始化要用
        Field[] fields = clazz.getDeclaredFields();
        Object[] objArgs = new Object[fields.length];
        int index = 0;
        //根据属性名，从配置文件获取值
        for (Field field : fields) {
            //拿到对应的属性名和配置信息
            String name = field.getName();
            String value = (String) properties.get(name);
            //这里得到的都是字符类型，有其他类型目前不知道怎么处理，只有写if判断
            if (name == "age") {
                int anInt = Integer.parseInt(value);
                objArgs[index++] = anInt;
            } else if (name == "sala") {
                double aDouble = Double.parseDouble(value);
                objArgs[index++] = aDouble;
            } else
                objArgs[index++] = value;
        }

        //根据获取到的配置信息参数，创建对象
        Constructor con = clazz.getDeclaredConstructor(String.class, String.class, String.class, int.class, double.class);
        con.setAccessible(true);
        Object obj = con.newInstance(objArgs);

        //调用方法 要传入参数
        method.invoke(obj);
        */
        Boyfriend boyfriend = Boyfriend.getBoyfriend();
        System.out.println(boyfriend);

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


class Boyfriend {
    private String name;
    private static Boyfriend boyfriend;

    public static Boyfriend getBoyfriend() {
        if (boyfriend == null) {
            boyfriend = new Boyfriend("小帅");
        }
        return boyfriend;
    }

    private Boyfriend(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boyfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
