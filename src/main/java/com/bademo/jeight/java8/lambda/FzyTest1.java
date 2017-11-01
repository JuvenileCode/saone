package com.bademo.jeight.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created Info:张龙Lambda表达式学习1
 * User: dota.liu.bin@gmail.com
 * Date: 2017/10/30 0030.21:12
 */
public class FzyTest1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2,3, 4, 5, 6, 7, 8);

        //Consumer @FunctionalInterface(函数式接口)用于lambda表达式
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("------------");
        //Lambda 表达式写法
        list.forEach(integer -> System.out.println(integer));
        System.out.println("------------");
        list.forEach(System.out::print); //method reference - Lambda方法引用
    }
}
