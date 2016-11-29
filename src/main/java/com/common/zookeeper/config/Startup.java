package com.common.zookeeper.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by MHorse on 2016/5/27.
 */
public class Startup {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:/config/applicationContext.xml");
    }
}
