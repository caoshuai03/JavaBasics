package com.sina.crm.map_;

import java.util.*;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
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
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add("aa");
        System.out.println(list.get(1));
    }
}

class Single{
    private static volatile Single instance;
    private Single(){}

    public static Single getInstance(){
        if (instance==null){//二次检查
            //一次检查后，加锁
            synchronized(Single.class){
                if (instance==null){
                    //实例化
                    instance= new Single();
                }
            }
        }
        return instance;

    }
}

