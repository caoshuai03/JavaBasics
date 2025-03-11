package com.sina.crm.enum_;

import java.util.ArrayList;

/**
 * @author caoshuai
 * @version 1.0
 */


public class Main {
    public static void main(String[] args) {
        // 计算地球表面的重力加速度
        double earthGravity = Planet.EARTH.surfaceGravity();
        String str1="sssss";
        String str2="sssssx";
        int i = str1.compareTo(str2);

        int[] ints=new int[]{1,2,3};
        ArrayList<Integer> list = new ArrayList<>();


        for (int anInt : ints) {
            list.add(anInt);
        }
        System.out.println(list);
//        Planet[] values = Planet.values();
//        for (Planet value : values) {
//
//            System.out.println(value);
//        }

    }
}
