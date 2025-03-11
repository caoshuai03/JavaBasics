package com.sina.crm.static_;

public class test01 {
    public static void main(String[] args) {
        new CellPhone() {
        }.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        new CellPhone() {
        }.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }

}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmclock(Bell bell) {
        bell.ring();
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






