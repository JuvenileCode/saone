package com.bademo.jeight.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/7 22:37
 * @Description: Atomic CAS原子操作
 */
public class AtomicUpdateTest {

    public static void main(String[] args) {

        Person person = new Person();

        /*for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(person.age++);
            }).start();
        }*/

        AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Person.class,"age");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicIntegerFieldUpdater.getAndIncrement(person));

            }).start();
        }
    }

}

class Person {
     volatile int age = 1;

}
