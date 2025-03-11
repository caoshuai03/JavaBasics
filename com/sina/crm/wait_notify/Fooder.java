package com.sina.crm.wait_notify;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Fooder extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                //先判断资源
                if (Desk.count == 0)
                    break;
                if (Desk.foodNoodle == 1) {
                    //如果有面，就吃面，然后设置变量并唤醒
                    Desk.count--;
                    if (Desk.count > 0)
                        System.out.println(Thread.currentThread().getName() + "正在吃面，还有" + Desk.count + "碗面可以吃");
                    else System.out.println(Thread.currentThread().getName() + "正在吃面，10碗面已经被吃完了");
                    Desk.foodNoodle = 0;
                    Desk.lock.notifyAll();
                } else {
                    //没有面，就等待
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
