package com.sina.crm.wait_notify;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Cook extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) break;
                if (Desk.foodNoodle == 1) {
                    //有面，就等待
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    //没有面，就做面，设置状态，做完再唤醒
                    System.out.println(Thread.currentThread().getName() + "正在做面");
                    Desk.foodNoodle = 1;
                    Desk.lock.notifyAll();
                }
            }
        }
    }
}
