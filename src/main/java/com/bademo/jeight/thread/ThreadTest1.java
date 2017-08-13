package com.bademo.jeight.thread;

import java.util.ArrayList;

/**
 * Created by:多线程练习
 *
 * @author Bin.l
 * @date 2017/8/12 16:02
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        SellThread st=new SellThread();
        for(int tc=5;tc>0;tc--){
            new Thread(st,"线程"+tc).start();
        }
    }
}

class SellThread implements Runnable {

    int tickets = 50000;

    public void run() {
        while (true){
            js();
            if(tickets==0){
                break;
            }
        }

    }

    public synchronized void js() {
        if (tickets > 0) {
            System.out.println("obj:" + Thread.currentThread().getName() + " sell tickets:" + tickets);
            tickets--;
        }
    }
}


