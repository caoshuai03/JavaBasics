package com.sina.crm.moban;

/**
 * @author caoshuai
 * @version 1.0
 * 介绍: 确保一个类只有一个实例，并提供一个全局访问点。
 * 使用场景: 当需要控制资源（如数据库连接、线程池）或确保全局唯一性时使用。
 */
class Boyfriend {
    private String name;
    private static Boyfriend boyfriend;

    public static Boyfriend getBoyfriend() {
        if (boyfriend == null) {
            boyfriend = new Boyfriend("小帅");
        }
        return boyfriend;
    }

    private Boyfriend(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boyfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
