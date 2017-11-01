package com.bademo.jeight.java8.lambda;

/**
 * Created Info:张龙Lambda表达式学习2
 * User: dota.liu.bin@gmail.com
 * Date: 2017/10/31 0031.19:56
 */

@FunctionalInterface
interface FzyInterface{
    void test();

    String toString(); //重定义Object的方法不会破坏函数式接口的语义

    //可以定义default方法
    default void s2(){
        System.out.println("this");
    }
}

public class FzyTest2 {

    public void fzyTest(FzyInterface fzyInterface){
        System.out.println(1);
        fzyInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        FzyTest2 n2 = new FzyTest2();
        n2.fzyTest(() -> {
            System.out.println("myTest");
        });
        System.out.println("--------------------");
        //lambda 可以理解为FzyInterface接口的实现
        FzyInterface fzyInterface = () -> {
            System.out.println("hello");
        };
        System.out.println(fzyInterface.getClass());
        System.out.println(fzyInterface.getClass().getSuperclass());
        System.out.println(fzyInterface.getClass().getInterfaces()[0]);
    }

}
