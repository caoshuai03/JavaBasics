package com.sina.crm.reflectionwork01;

import com.sina.crm.reflection_.Dog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Dog dog = new Dog("小白", 9);
        Person person = new Person("小帅", "1234567", "四川省成都市", 18, 999999.9999);

//        saveObject(dog);
        saveObject(person);


    }

    public static void saveObject(Object obj) throws IllegalAccessException, IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt"));
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            bufferedWriter.write(name + "=" + value);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
