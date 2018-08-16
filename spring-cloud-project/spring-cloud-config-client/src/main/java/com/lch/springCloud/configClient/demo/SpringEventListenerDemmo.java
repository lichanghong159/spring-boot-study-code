package com.lch.springCloud.configClient.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lichanghong on 2018-07-31
 **/
public class SpringEventListenerDemmo {
    public static void main(String[] args) {
        //Annotation驱动Spring应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册监听器
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent event) {
                System.out.println(event.getSource());
            }
        });
        //重新注册
        context.refresh();
        //发布事件
        context.publishEvent(new MyApplicationEvent("你好"));
        //监听器得到事件
    }
    private static class MyApplicationEvent extends ApplicationEvent{


        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
