package com.sina.crm.test1;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void manage() {
        System.out.println(getName() + " " + "is managing");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + getBonus();
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
