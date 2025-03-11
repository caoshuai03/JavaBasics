package com.sina.crm.concurrenthashmap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();


        // 创建一个HashMap集合对象
        HashMap<String, String> hashMap = new HashMap<String, String>();


        // 创建两个线程对象,我们本次使用匿名内部类的方式去常见线程对象
        Thread t1 = new Thread() {

            @Override
            public void run() {

                // 第一个线程对象向集合中添加元素(1-24)
                for (int x = 1; x < 25; x++) {
                    hashMap.put(String.valueOf(x), String.valueOf(x));
                }

            }

        };

        // 线程t2
        Thread t2 = new Thread() {

            @Override
            public void run() {

                // 第二个线程对象向集合中添加元素(25-50)
                for (int x = 25; x < 51; x++) {
                    hashMap.put(String.valueOf(x), String.valueOf(x));
                }

            }

        };

        // 启动线程
        int k = 0;
        while (k < 10) {
            t1.start();
            t2.start();


        System.out.println("----------------------------------------------------------");

        try {

            // 主线程休眠2s，以便让其他两个线程将数据填装完毕
            TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 从集合中找出键和值不相同的数据
        for (int x = 1; x < 51; x++) {

            // HashMap中的键就是当前循环变量的x这个数据的字符串表现形式 ， 根据键找到值，然后在进行判断
            if (!String.valueOf(x).equals(hashMap.get(String.valueOf(x)))) {
                System.out.println(String.valueOf(x) + ":" + hashMap.get(String.valueOf(x)));
            }

        }
        hashMap.clear();

            k++;
        }


    }

}
