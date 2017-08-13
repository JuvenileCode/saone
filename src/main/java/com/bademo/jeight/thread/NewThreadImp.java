package com.bademo.jeight.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by:多线程测试
 * @author Bin.l
 * @date 2017/8/10 22:19
 */
public class NewThreadImp {

    public static void main(String[] args) {
        System.out.println("进入线程 "+Thread.currentThread().getName());
        NewThreadImp nti = new NewThreadImp();

        NewThreadA threadA = new NewThreadA();
        threadA.setName("线程1");
        threadA.start();
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"等待");
            threadA.join();//threadA线程执行
            System.out.println("线程"+Thread.currentThread().getName()+"继续执行");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class NewThreadA extends Thread{
    private static int num = 0;

    public NewThreadA(){
        num++;
    }

    @Override
    public void run() {
        System.out.println("进入线程 " + Thread.currentThread().getName());
        for (int i = 10; i >= 0; i--) {
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " " + i);
        }
        System.out.println("线程"+Thread.currentThread().getName()+"执行完毕");
    }
}
