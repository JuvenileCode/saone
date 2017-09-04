package com.bademo.jeight.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by:Volatile关键字
 *
 * @author Bin.l
 * @date 2017/9/2 14:21
 */
public class VolatileTest {

    public volatile int inc = 0;

    Lock lock = new ReentrantLock();

    public  void increase() {
        lock.lock();
        try {
            inc++;
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final VolatileTest vt = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        vt.increase();
                    }
                }

                ;
            }.start();
        }
        //此方法用来判断所有线程是否执行完有问题
        /*while (Thread.activeCount() > 1){
            //保证前面的线程都执行完
            Thread.yield();
        }*/
        //暂时线程休眠来处理-[http://blog.csdn.net/p106786860/article/details/52497215]
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(vt.inc);
    }
}
