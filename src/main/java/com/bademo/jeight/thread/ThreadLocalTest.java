package com.bademo.jeight.thread;

/**
 * Created by
 * ：ThreadLocal(线程本地变量)-为变量在每个线程中都创建了一个副本
 * @author Bin.l
 * @date 2017/9/3 20:54
 */
public class ThreadLocalTest {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.set();
        System.out.println(threadLocalTest.getLong() + " " + threadLocalTest.getString());

        Thread thread1 = new Thread() {
            public void run() {
                threadLocalTest.set();
                System.out.println(threadLocalTest.getLong() + " " + threadLocalTest.getString());
            };
        };
        thread1.start();
        thread1.join();
        System.out.println(threadLocalTest.getLong() + " " + threadLocalTest.getString());
    }

}
