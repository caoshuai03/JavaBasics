package com.sina.crm.test;

public class Graduate extends Student{
    public int n1=1;
    protected int n2=1;
    int n3=1;
    private int n4=1;


    public void test(){

    }

    @Override
    public void m1() {
        System.out.println("子类方法");
    }
    public void m2(){
        System.out.println("子类方法m2");
    }
}
