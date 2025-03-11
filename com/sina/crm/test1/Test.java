package com.sina.crm.test1;

public class Test {
    public static void main(String[] args) {
        C c = new D();//看左边编译类型为C
        D d = new D();
        System.out.println(d.name);
        System.out.println(c.name);//调用静态变量看编译类型
    }


    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());

    }

    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        } else System.out.println("错误");

    }
}

class C {
    static String name = "jack";
}

class D extends C {
    static String name = "merry";
}


