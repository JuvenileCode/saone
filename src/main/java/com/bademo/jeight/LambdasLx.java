package com.bademo.jeight;

/**
 * Created by:Lambda 表达式练习
 *
 * @author Bin.l
 * @date 2017/4/25 22:17
 */
public class LambdasLx {

    public static void main(String[] args) {
        LambdasLx.lanStr();
    }

    /**
     * Lambda表达式由参数、 头和主体组成
     */
    private static void lanStr() {

        Runnable r1 = () -> System.out.println("Hello world 1");
        r1.run();
        process(() -> System.out.println("woshi".length()));
    }

    private static void process(Runnable r){
        r.run();
    }
}
