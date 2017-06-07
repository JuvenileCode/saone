package com.bademo.aoplx;

import com.bademo.aoplx.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by:启用注解配置类
 *
 * @author Bin.l
 * @date 2017/6/7 22:23
 */
@Configuration  //表示这个类可以使用 Spring IoC 容器作为 bean 定义的来源
@EnableAspectJAutoProxy  //启用自动代理功能
/*
 * 开启spring的注解扫描 可以设置一个值指定basePackages，就是开始扫描的包,如果没有设置 默认从定义这个注解的类所属包开始一直到所有子包。
 */
@ComponentScan
public class ConcertConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }

}
