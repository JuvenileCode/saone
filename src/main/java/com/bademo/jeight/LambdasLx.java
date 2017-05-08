package com.bademo.jeight;

import org.springframework.beans.BeanUtils;

import java.util.function.Predicate;

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
        String[] aa={"aa","bb","cc"};
        String[] bb=LambdasLx.strFilter(aa,(String s)->"cc".equals(s));
        System.out.println(bb[0]);

    }

    private static void process(Runnable r){
        r.run();
    }

    public static String[] strFilter(String[] sz, Predicate<String> p){
        String[] sztow=new String[sz.length];
        for (String szStr:sz){
            if(p.test(szStr)){
                sztow[0]=szStr;
            }
        }
        return sztow;
    }
}
