package com.bademo.aoplx.time;

import org.springframework.stereotype.Component;

/**
 * @auther: Bin.L
 * @date: 2020/04/10 16:34
 * @Description:
 */
@Component
@TimeConsuming
public class TestClassBaseMonitor {

    public String testTimeConsuming(String msg) throws InterruptedException {
        System.out.println(msg);
        Thread.sleep(600);
        testPackagePrivateMethod(msg);
        return "OK";
    }

    public String testTimeConsumingWithAnno(String a, String b) {
        System.out.println("I'm class annotated, a:" + a + ", b:" + b);
        return "OK2";
    }

    String testPackagePrivateMethod(String msg) {
        System.out.println("go2: " + msg);
        return "OK3";
    }
}
