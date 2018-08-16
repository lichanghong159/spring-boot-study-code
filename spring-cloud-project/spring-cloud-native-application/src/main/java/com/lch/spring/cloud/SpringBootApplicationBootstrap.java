package com.lch.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lichanghong on 2018-07-29
 **/
@EnableAutoConfiguration
public class SpringBootApplicationBootstrap {
    public static void main(String[] args) {
       // SpringApplication.run(SpringBootApplicationBootstrap.class,args);
        //替换写法
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setId("lch");
        context.refresh();
        new SpringApplicationBuilder(SpringBootApplicationBootstrap.class)
                .parent(context)//显式地设置双亲上下文
                .run(args);
    }
}
