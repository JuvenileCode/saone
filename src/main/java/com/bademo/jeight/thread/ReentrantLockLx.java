package com.bademo.jeight.thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by:Lock练习
 * :
 * @author Bin.l
 * @date 2017/8/12 22:21
 */
public class ReentrantLockLx {

    private List<Integer> arrayList = new ArrayList<>();
    Lock lock = new ReentrantLock(); //可重入锁
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        ReentrantLockLx rtl = new ReentrantLockLx();

        new Thread("测试线程一"){
            public void run() {
                //rtl.insert(Thread.currentThread());
                //rtl.insert2(Thread.currentThread());
                rtl.get(Thread.currentThread());
            };
        }.start();

        new Thread("测试线程二"){
            public void run() {
                //rtl.insert(Thread.currentThread());
                //rtl.insert2(Thread.currentThread());
                rtl.get(Thread.currentThread());
            };
        }.start();
    }

    /**
     * ReentrantLock 可重入锁
     * @param thread
     */
    private void insert(Thread thread){
        lock.lock();
        try {
            System.out.println(thread.getName()+" 得到了锁");
            for (int i=0;i<5;i++){
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName()+" 释放了锁");
            lock.unlock();
        }
    }

    /**
     * ReentrantLock 可重入锁
     * @param thread
     */
    private void insert2(Thread thread){
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName()+" 得到了锁");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(thread.getName()+" 释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+" 获取锁失败");
        }
    }

    /**
     * ReentrantReadWriteLock 读写锁
     * @param thread
     */
    public void get(Thread thread){
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }

}


