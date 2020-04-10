package com.bademo.aoplx.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @auther: Bin.L
 * @date: 2020/04/10 16:13
 * @Description: 测试方法级别
 */
@Component
public class TestMethodBaseMonitor {

    private static final Logger log = LoggerFactory.getLogger(TestMethodBaseMonitor.class);


    @TimeConsuming
    public String testTimeConsuming(String a, String b) {
        log.info("I'm method annotated, a:" + a + ", b:" + b);
        return a+" <--> "+b;
    }

    @TimeConsuming(logLevel = 2, useSourceClassLog = true)
    public String testDebugLevel(String a, String b) {
        log.info("debug level and useSourceClassLog:" + a + ", b:" + b);
        return "haha";
    }
}
