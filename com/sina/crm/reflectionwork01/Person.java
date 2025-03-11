package com.sina.crm.reflectionwork01;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Person {
    private String name;
    private String phone;
    private String address;
    private int age;
    private double sala;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sala=" + sala +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSala() {
        return sala;
    }

    public void setSala(double sala) {
        this.sala = sala;
    }

    public Person(String name, String phone, String address, int age, double sala) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.sala = sala;
    }
}
