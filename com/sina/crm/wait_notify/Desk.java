package com.sina.crm.wait_notify;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Desk {
    //0没有面 1有面
    static int foodNoodle = 0;
    static Object lock = new Object();//锁对象
    static int count = 10;//共享资源截止条件
}
