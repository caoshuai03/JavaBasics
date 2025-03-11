package com.sina.crm.thread_;

import java.util.concurrent.*;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Thread02 {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        pool.submit(new Hw());
//        pool.submit(new Hw());
//        pool.submit(new Hw());
//        pool.submit(new Hw());


        //自定义线程池
        /*
        核心线程数量

线程池最大线程数量

空闲时间（值）

空闲时间（单位）

/

创建线程方式

执行任务过多的解决方案

         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数量
                6,//线程池最大线程数量
                60,//空闲时间（值）
                TimeUnit.SECONDS,//空闲时间（单位）
                new ArrayBlockingQueue<>(3),//阻塞队列
                Executors.defaultThreadFactory(),//创建线程方式，线程工厂
                new ThreadPoolExecutor.AbortPolicy()//执行任务过多的解决方案
        );
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

    }
}




