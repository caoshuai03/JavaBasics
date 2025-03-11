package com.sina.crm.collection_;

public class Employee {
    private String name;
    private double sala;
    private BirthDay birthDay;

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sala=" + sala +
                ", birthDay=" + birthDay +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSala() {
        return sala;
    }

    public void setSala(double sala) {
        this.sala = sala;
    }

    public BirthDay getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(BirthDay birthDay) {
        this.birthDay = birthDay;
    }

    public Employee(String name, double sala, BirthDay birthDay) {
        this.name = name;
        this.sala = sala;
        this.birthDay = birthDay;
    }
}