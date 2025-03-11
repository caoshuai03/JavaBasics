package com.sina.crm.lock_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();

        a1.start();
        a2.start();
        a3.start();




    }
}

class A extends Thread {

    private static int tickts = 0;
    static Lock lock = new ReentrantLock();//Lock是接口，只能用它的实现类

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();//上锁
                if (tickts == 100) {
                    break;
                }
                Thread.sleep(10);
                tickts++;
                System.out.println(Thread.currentThread().getName() + "卖了" + tickts + "张票");
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                //使用finally，确保每次都能释放锁
                lock.unlock();
            }
        }
    }
}
