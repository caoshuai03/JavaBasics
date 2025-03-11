package com.sina.crm.reflection_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Reflection_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //得到类对象
        Class<?> clazz = Class.forName("com.sina.crm.reflection_.Dog");
        Constructor<?> con = clazz.getDeclaredConstructor(String.class, int.class);
        //暴力反射，临时取消权限校验
        con.setAccessible(true);
        //用私有构造器创建对象
        Dog d1 = (Dog) con.newInstance("小白", 8);

        //获取成员变量对象
        Field name = clazz.getDeclaredField("name");
        //临时取消权限校验
        name.setAccessible(true);
        //传入对象d1，获取其name值
        Object o = name.get(d1);
        name.set(d1, "小黑");

        //调用方法名；传入参数类对象
        Method m = clazz.getDeclaredMethod("info", String.class, int.class);

        m.setAccessible(true);
        //调用m方法的对象，m方法传入的形参
        Object info = m.invoke(d1, name.get(d1), 8);


        System.out.println(info);


    }
}


