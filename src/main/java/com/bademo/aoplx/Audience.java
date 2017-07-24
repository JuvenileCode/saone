package com.bademo.aoplx;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by:定义切面
 *
 * @author Bin.l
 * @date 2017/6/7 22:08
 */
@Aspect
@Component
public class Audience {

    //@Pointcut("execution(* com.bademo.aoplx.cat*(..)) && within(com.bademo.aoplx.cat*)")
    @Pointcut("execution(* com.bademo.action.controller.BookBootController.*(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("方法调用之前被调用...");
    }

}
