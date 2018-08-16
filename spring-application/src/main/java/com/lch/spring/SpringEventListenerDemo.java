package com.lch.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author: lichanghong on 2018-07-18
 **/
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        //监听
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.err.println(event);
            }
        });
        //启动spring应用上下文
        context.refresh();
        //spring应用上下发布事件
        context.publishEvent("helloWord");
    }
}
