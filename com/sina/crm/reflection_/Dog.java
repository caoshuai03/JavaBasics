package com.sina.crm.reflection_;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Dog extends Object {

    private String name;
    private int age;

    public String info(String name, int age) {
        return name + "已经" + age + "岁啦";
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
