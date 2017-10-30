package com.bademo.jeight.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created Info: ThreadPoolExecutor 线程池learn
 * User: dota.liu.bin@gmail.com
 * Date: 2017/10/10 0010.20:12
 */
public class PoolThreadA {

    public static void main(String[] args) {
        //initialization thread pool
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10
                , 200, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
//http://www.cnblogs.com/trust-freedom/p/6594270.html
class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}