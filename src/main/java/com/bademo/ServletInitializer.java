package com.bademo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created Info:springBoot打包War发布到tomcat
 * User: dota.liu.bin@gmail.com
 * Date: 2017/10/31 0031.14:46
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SaoneApplication.class);
    }
}
