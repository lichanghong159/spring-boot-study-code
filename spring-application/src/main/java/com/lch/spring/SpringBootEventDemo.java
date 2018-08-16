package com.lch.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author: lichanghong on 2018-07-18
 **/
@EnableAutoConfiguration
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                //增加监听
                .listeners(event -> {
            System.err.println("监听到事件->"+event.getClass().getName());
        }).run(args).close();
    }
}
