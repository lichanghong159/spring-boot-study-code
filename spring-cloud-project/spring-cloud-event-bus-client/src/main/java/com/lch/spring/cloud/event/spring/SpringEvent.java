package com.lch.spring.cloud.event.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lichanghong on 2018-08-18
 **/
public class SpringEvent {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addApplicationListener(e->{
            System.err.println("监听事件:->"+e.getClass().getName());
        });
        context.refresh();
        context.start();
        context.stop();
        context.close();
    }
}
