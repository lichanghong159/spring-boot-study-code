package com.lch.spring.cloud.event.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * @author: lichanghong on 2018-08-18
 **/
public class SpringAnnotationDriverEvent {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //将SpringAnnotationDriverEvent转成bean
        context.register(SpringAnnotationDriverEvent.class);
        context.refresh();
        context.publishEvent(new myApplicationEvent("你好"));
        context.close();
    }
    private static class myApplicationEvent extends ApplicationEvent{

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public myApplicationEvent(Object source) {
            super(source);
        }
    }
    @EventListener
    public void onMessage(myApplicationEvent event){
        System.err.println("监听到myApplicationEvent事件源:"+event.getSource());
    }
}
