package com.lch.spring;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @author: lichanghong on 2018-07-18
 **/
public class ApplicationEventMulticasterDemo {
    public static void main(String[] args) {
        ApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        //添加监听器
        multicaster.addApplicationListener(event -> {
            System.out.println("接收到事件->"+event);
        });
        //发布/广播时间
        multicaster.multicastEvent(new PayloadApplicationEvent<Object>("1","你好!"));
        multicaster.multicastEvent(new PayloadApplicationEvent<Object>("2","你好!"));
    }
}
