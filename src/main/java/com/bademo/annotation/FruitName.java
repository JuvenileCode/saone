package com.bademo.annotation;

import java.lang.annotation.*;

/**
 * Created by:自定义注解练习
 *
 * @author Bin.l
 * @date 2017/6/8 21:26
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

    String desc();

    String author();

    int age() default 18;

}
