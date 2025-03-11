package com.sina.crm.thread_;

import java.util.Date;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();

    }
}

class MaiPiao implements Runnable {

    public static int tickts = 0;
    static Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                tickts++;
            }
        }

    }
}


class Hw implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello,world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hi implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
