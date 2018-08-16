package com.lch.spring.cloud.stream.rabbitMq.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息的消费者
 * @createby: lichanghong on 2018-08-16 23:00
 **/
public interface SimpleMessageReceiver {
    @Input("lch2018")//设置通道名称与配置文件的配置一致
    SubscribableChannel channel();
}
