package com.lch.spring.cloud.stream.rabbitMq;

import com.lch.spring.cloud.stream.rabbitMq.service.SimpleMessageReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.SubscribableChannel;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

/**
 * @author: lichanghongn 2018-08-16
 **/
@SpringBootApplication
@EnableBinding(SimpleMessageReceiver.class)
public class SpringCloudServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudServerApplication.class).web(WebApplicationType.SERVLET)
                .run(args);
    }
    @Autowired
    SimpleMessageReceiver simpleMessageReceiver;
    //接口编程
    @PostConstruct//当构造结束时
    public void init(){
        //获取SubscribableChannel
        SubscribableChannel subscribableChannel = simpleMessageReceiver.channel();
        //订阅消息
        subscribableChannel.subscribe(msg->{
            MessageHeaders headers = msg.getHeaders();
            String encoding = (String) headers.get("charset-encoding");
            byte[] content = (byte[]) msg.getPayload();
            try {
                System.out.println("接受到消息：" + new String(content, encoding));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }
    //spring cloud stream注解编程
    @StreamListener("lch2018")
    public void onMessage(byte [] data){
        System.out.println("onMessage:byte [] ->"+new String(data));
    }
    //spring cloud stream注解编程
    @StreamListener("lch2018")
    public void onMessage(String data){
        System.out.println("onMessage:String  ->"+data);
    }

    @ServiceActivator(inputChannel = "lch2018")
    public void onMessage2(String data){
        System.out.println("onMessage:Activator  ->"+data);
    }
}
