package com.bademo.jeight.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by:多线程测试
 * @author Bin.l
 * @date 2017/8/10 22:19
 */
public class NewThreadImp {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());

        NewThreadA threadA = new NewThreadA();
        threadA.setName("线程1");
        threadA.start();

        NewThreadA threadAb = new NewThreadA();
        threadAb.setName("线程2");
        threadAb.start();
    }
}

class NewThreadA extends Thread{
    private static int num = 0;

    public NewThreadA(){
        num++;
    }

    @Override
    public void run() {
            for (int i = 30; i >= 0; i--) {
                System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " " + i);
            }
    }
}
