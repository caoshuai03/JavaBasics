package com.sina.crm.test;

public class Test {
    public static void main(String[] args) {
        Student student= new Graduate();

        System.out.println(student.n2);
        ((Graduate) student).m2();

        System.out.println(student instanceof Graduate);





    }
}

enum Day {
    MONDAY,  // 星期一
    TUESDAY, // 星期二
    WEDNESDAY, // 星期三
    THURSDAY, // 星期四
    FRIDAY,  // 星期五
    SATURDAY, // 星期六
    SUNDAY   // 星期日
}
