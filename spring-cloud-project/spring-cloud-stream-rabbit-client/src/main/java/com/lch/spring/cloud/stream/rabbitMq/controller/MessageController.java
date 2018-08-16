package com.lch.spring.cloud.stream.rabbitMq.controller;

import com.lch.spring.cloud.stream.rabbitMq.service.SimpleMessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lichanghong on 2018-08-16
 **/
@RestController
public class MessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;//使用rabbitMQAPI
    @Autowired
    SimpleMessageService simpleMessageService;
    @GetMapping("/send")
    public String sendMsg(@RequestParam String msg){
        rabbitTemplate.convertAndSend(msg);
        return "Ok";
    }
    @GetMapping("/stream/send")
    public boolean streamSend(@RequestParam String msg){
        //获取messageChannel
        MessageChannel messageChannel = simpleMessageService.channel();
        //设置headers
        Map<String,Object> headers = new HashMap<>();
        headers.put("charset-encoding","UTF-8");
        headers.put("content-type", MediaType.TEXT_PLAIN_VALUE);
        return messageChannel.send(new GenericMessage(msg,headers));
    }
}
