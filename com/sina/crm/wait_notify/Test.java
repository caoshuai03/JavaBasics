package com.sina.crm.wait_notify;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Cook cook = new Cook();
        Fooder fooder = new Fooder();

        cook.setName("厨师");
        fooder.setName("小帅");
        cook.start();
        fooder.start();

    }
}
