package com.lch.spring.cloud.stream.rabbitMq.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * @createby: lichanghong on 2018-08-16 23:00
 **/
public interface SimpleMessageService {
    @Output("lch2018")//设置通道名称与配置文件的配置一致
    MessageChannel channel();
}
