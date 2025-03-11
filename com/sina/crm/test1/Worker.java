package com.sina.crm.test1;

public class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }

    public void work() {
        System.out.println(getName() + " " + "is working");
    }

    @Override
    public boolean equals(Object obj) {
        //用于判断两个对象的属性是否相同
        if (this == obj) return true;//如果指向的同一个对象，就肯定相同
        if (obj instanceof Worker) {//判断两个对象是不是同一个类
//            return this.getName().equals(((Worker) obj).getName()) && this.getSalary() == ((Worker) obj).getSalary();
            return this.getName() == ((Worker) obj).getName() && this.getSalary() == ((Worker) obj).getSalary();
           /* 细节比较多
            private String name;
            private double salary;
           this.getName 子类可以调用父类的成员，继承的知识
           ((Worker) obj).getName()，因为obj是父类引用->子类，必须向下转型才能调用子类的，多态的知识
           而向下转型的前提是obj指向的对象的Worker对象，所以有obj instanceof Worker判断obj的运行类型是不是Worker类型
            .equals,是因为name是String类型，已经重写了，是判断字符串的值是否相等
           ==，是因为double是基本类型，用==判断值相同
            */
        }
        return false;
    }
}
