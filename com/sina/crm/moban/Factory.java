package com.sina.crm.moban;

/**
 * @author caoshuai
 * @version 1.0
 * 介绍: 定义一个创建对象的接口，但让子类决定实例化哪个类。
 * 使用场景: 当需要根据条件创建不同对象时使用。
 */
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
    String name = null;//public static final 可以访问、接口直接访问、不能修改 是一个常量
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